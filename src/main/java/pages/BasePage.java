package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    static WebElement find(By locator){
        try{
            return Driver.getCurrentDriver().findElement(locator);
        }catch (Exception e){
            System.out.println("no fund");
            e.printStackTrace();
            try {
                Driver.getCurrentDriver().findElement(text("下次再说")).click();
                return Driver.getCurrentDriver().findElement(locator);
            }catch (Exception e1){return  null;}
        }
    }

    static By locate(String locator){
        if(locator.matches("/.*")){
            return By.xpath(locator);
        }else{
            return By.id(locator);
        }
    }
    static By text(String content){

        return By.xpath("//*[@text='"+ content + "']");
    }
}
