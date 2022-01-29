package pages;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoreMembershipPage  extends TestBase{

    private final WebDriver driver;


    public CoreMembershipPage(WebDriver driver){
        this.driver=driver;
    }


    @FindBy(css = "#ways_to_fly-component-3 > app-module-title > div > h1")
    private WebElement privateAviationHead;
    @FindBy(xpath = "//h1[contains(text(), 'Wheels Up Core Membership')]")
    private WebElement pageTitleBanner;
    @FindBy(xpath = "//h3[contains(text(), 'SHARED FLIGHTS')]")
    private WebElement sharedFlightsH3;
    @FindBy(xpath = "//h3[contains(text(), 'SHUTTLE FLIGHTS')]")
    private WebElement shuttleFlightsH3;
    @FindBy(xpath = "//h3[contains(text(), 'HOT FLIGHTS')]")
    private WebElement hotFlightsH3;
    @FindBy(xpath = "//h1[contains(text(), 'Learn more today')]")
    private WebElement learnMore;
    @FindBy(xpath = "//a[contains(text(), 'CONTINUE')]")
    private WebElement continueBtn;



    public void scrollToPrivateAviationHeader(){
        getText(pageTitleBanner);
        System.out.println("====================== "+getText(pageTitleBanner));
        scrollToElement(hotFlightsH3, driver);
    }

    public String getShuttleFlightsText(){
        return getText(shuttleFlightsH3);
    }

    public String getHotFlightsText(){
        return getText(hotFlightsH3);
    }

    public String getSharedFlightsText(){
        return getText(sharedFlightsH3);
    }

    public void scrollToLearnMore(){
//        waitElement(learnMore);
        scrollToElement(continueBtn, driver);
        System.out.println(" =========== "+getText(learnMore)+" ============ ");
    }

    public void clickOnContinue(){
        jsClick(continueBtn);
    }

}
