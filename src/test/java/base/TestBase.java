package base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import com.google.common.base.Function;

public class TestBase {

    DriverManager driver = DriverManager.getInstance();
    static PropFileReader reader = new PropFileReader("application.properties");


    public void navigateToUrl(){
        driver.getDriver().get(reader.getProperty("app.driver.url"));
    }

    public WebElement getElementWithFluentWait(By element){

        Wait wait = new FluentWait<WebDriver>(driver.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NotFoundException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotVisibleException.class);
        WebElement ele = (WebElement) wait.until(new Function<WebDriver, WebElement>(){

            public WebElement apply( WebDriver driver) {
                return driver.findElement(element);
            }
        });

        return ele;
    }



    public void waitElement(WebElement ele){
        WebDriverWait wait = new WebDriverWait(driver.getDriver(),15,3000);
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public void waitElementToBeClickable(WebElement ele){
        WebDriverWait wait = new WebDriverWait(driver.getDriver(),15,3000);
        wait.until(ExpectedConditions.elementToBeClickable(ele));
    }


    public void highlightElement(WebElement element) {
        for (int i = 0; i <3; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver.getDriver();
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: yellow; border: 2px solid yellow;");
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
        }
    }

    public void click(WebElement ele){
        waitElement(ele);
        waitElementToBeClickable(ele);
        ele.click();

    }

    public void jsClick(WebElement ele){
        JavascriptExecutor executor = (JavascriptExecutor)driver.getDriver();
        executor.executeScript("arguments[0].click();", ele);
    }

    public String getText(WebElement ele){
            waitElement(ele);
            return ele.getText();
    }

    public void scrollToElement( WebElement ele, WebDriver driver){
        Actions a = new Actions(driver);
        a.moveToElement(ele);
        a.perform();
        }

        public void scrollToEndOfPage(){
            JavascriptExecutor js = (JavascriptExecutor) driver.getDriver();
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        }

    public void scrollToTopOfPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver.getDriver();
        js.executeScript("window.scrollBy(document.body.scrollHeight,0)");
    }

    public void typeTextToField(WebElement ele, String text){
        waitElement(ele);
        ele.sendKeys(text);
    }





}
