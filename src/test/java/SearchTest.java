import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;
import pages.SearchPage;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTest {

    static MainPage mainPage;
    static SearchPage searchPage;

    @BeforeAll
    static void beforeAll(){
        mainPage=MainPage.start();
        searchPage=mainPage.gotoSearch();
    }

    @ParameterizedTest
    @CsvSource({
            "pdd, 拼多多",
            "alibaba, 阿里巴巴",
            "sogo, 搜狗"
    })
    void searchTest(String keyword, String name){
        String content=searchPage.search(keyword).getAll().get(0);
        assertThat(content, equalTo(name));
    }

    @Test
    void selectTest(){
        ArrayList<String> array=searchPage.search("mi").addSelected();
        for(String s:array) {
            System.out.println(s);
        }
        assertThat(array, hasItems("com.xueqiu.android:id/followed_btn", "com.xueqiu.android:id/follow_btn"));
    }


    @Test
    void removeTest(){
        boolean result=searchPage.search("mi").removeSelected();
        assertThat(result, equalTo(true));
    }
}
