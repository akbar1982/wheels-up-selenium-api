package pages;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends TestBase {

    final WebDriver driver;


    public HomePage(WebDriver driver){
        this.driver=driver;
    }


    @FindBy(xpath = "//a[contains(text(), 'Fly')]")
    private WebElement flyMenu;
    @FindBy(xpath = "//a[contains(text(), 'CORE MEMBERSHIP')]")
    private WebElement coreMembershipLink;
    @FindBy(xpath = "//h1[contains(text(), 'Flying, Personalized.')]")
    private WebElement pageWelcomeTitle;
    @FindBy(xpath = "//h1[contains(text(), 'Discover The Possibilities')]")
    private WebElement discoverThePossibilitiesHeader;
    @FindBy(xpath = "//a[contains(text(), '855-FLY-8760')]")
    private WebElement phoneNumber;
    @FindBy(xpath = "//a[contains(text(), 'info@wheelsup.com')]")
    private WebElement emailAddress;
    @FindBy(xpath = "//span[contains(text(), '601 West 26th Street')]")
    private WebElement address;


    public String getPageWelcomeTitle(){
        return getText(pageWelcomeTitle);
    }

    public String scrollToDiscoverThePossibilitiesText(){
        scrollToElement(discoverThePossibilitiesHeader, driver);
        return getText(discoverThePossibilitiesHeader);
    }


    public String getPhoneNumber(){
        scrollToEndOfPage();
        return getText(phoneNumber);
    }

    public String getEmailAddress(){
        scrollToEndOfPage();
        return getText(emailAddress);
    }

    public String getAddress(){
        scrollToEndOfPage();
        return getText(address);
    }

    public void scrollToFlyMenu(){
        scrollToElement(pageWelcomeTitle, driver);
    }

    public void clickOnFlyMenu(){
        click(flyMenu);
    }

    public void clickOnCoreMembershipOptionInFlyMenu(){
        click(coreMembershipLink);
    }



}
