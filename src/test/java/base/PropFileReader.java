package base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropFileReader {

    BufferedReader reader = null;
    Properties properties = new Properties();

    public PropFileReader(String filePath) {
        try {
            reader = new BufferedReader(new FileReader("src/test/resources/"+filePath));
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getProperty(String propertyName){
            return properties.getProperty(propertyName);
    }


}
