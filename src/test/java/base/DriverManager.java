package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class DriverManager {

    private  WebDriver driver = null;
    private static DriverManager manager = null;
    PropFileReader reader = new PropFileReader("./application.properties");

    private DriverManager() {

    }

    public static DriverManager getInstance(){
        if(manager==null){
            manager = new DriverManager();
            return manager;
        }else{
            return manager;
        }
    }

    public   WebDriver getDriver(){

        if(driver == null) {
            if(reader.getProperty("app.browser.type").equals("firefox")){
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().deleteAllCookies();
                driver.manage().window().maximize();
                return driver;
            }else if(reader.getProperty("app.browser.type").equals("msedge")){
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().deleteAllCookies();
                driver.manage().window().maximize();
                return driver;
            }else{
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
//                driver.manage().deleteAllCookies();
                driver.manage().getCookies();
                driver.manage().window().maximize();
                return driver;
            }

        } else {
            return driver;
        }

    }

    public  void closeBrowser(){
        if(driver!=null){
            driver.close();

        }
    }


}
