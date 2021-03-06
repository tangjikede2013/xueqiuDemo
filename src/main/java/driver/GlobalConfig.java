package driver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class GlobalConfig {
    public AppiumConfig appium;

    static GlobalConfig load(String filePath){
        ObjectMapper mapper=new ObjectMapper(new YAMLFactory());
        try {
            GlobalConfig config=mapper.readValue(GlobalConfig.class.getResource(filePath),GlobalConfig.class);
            return config;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
