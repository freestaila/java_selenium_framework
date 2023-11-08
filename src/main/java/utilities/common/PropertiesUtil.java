package utilities.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtil {
    public static Properties loadProperties(String propName){
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String propertyPath = rootPath + propName;

        Properties prop = new Properties();
        try{
            prop.load(new FileInputStream(propertyPath));
        }catch (IOException e){
            e.printStackTrace();
        }
        return prop;
    }
}
