package pages;
import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Map;

public class RequestInfoPage extends TestBase {
    private final WebDriver driver;


    public RequestInfoPage(WebDriver driver){
        this.driver=driver;
    }


    @FindBy(xpath = "//div[@class='text-select']/p[@class='label']")
    private WebElement typeOfTravelDropdownMenu;
    @FindBy(xpath = "//p[text()='Personal Travel']")
    private WebElement personalTravelMenuOption;
    @FindBy(xpath = "//p[text()='Business Travel']")
    private WebElement businessTravelMenuOption;
    @FindBy(xpath = "//p[text()='Both']")
    private WebElement bothTravelMenuOption;
    @FindBy(xpath = "//input[@id='FirstName-clone']")
    private WebElement firstNameInput;
    @FindBy(xpath = "//input[@id='LastName-clone']")
    private WebElement lastNameInput;
    @FindBy(xpath = "//input[@id='Email-clone']")
    private WebElement emailInput;
    @FindBy(css = "#Phone-clone") // Scroll down at this point
    private WebElement phoneInput;
    @FindBy(css = "#Company__c-clone")
    private WebElement companyNameInput;
    @FindBy(css = "#Address-clone")
    private WebElement addressInput;
    @FindBy(css = "#City-clone")
    private WebElement cityInput;
    @FindBy(css = "#PostalCode-clone")
    private WebElement zipCodeInput;
    @FindBy(css = "#State-clone")
    private WebElement stateInput;
    @FindBy(css = "#Country-clone")
    private WebElement countryInput;
    @FindBy(xpath = "//div[@id='How_Many_Private_Flights_Per_Year__c-clone0']//p[text()='Please select one']")
    private WebElement privateFlightsCountYearDropdownMenu;
    @FindBy(xpath = "//p[text()='1-5']")
    private WebElement optionOneToFive;
    @FindBy(xpath = "//p[text()='0']")
    private WebElement optionZero;
    @FindBy(xpath = "//p[text()='5-10']")
    private WebElement optionFiveToTen;
    @FindBy(xpath = "//p[text()='10']")
    private WebElement optionTen;
    @FindBy(xpath = "//input[@type='radio' and @value='No']")
    private WebElement needTravelWithPetsNoOption;
    @FindBy(xpath = "//input[@type='radio' and @value='Yes']")
    private WebElement needTravelWithPetsYesOption;
    @FindBy(xpath = "//div[@id='Do_you_own_or_travel_to_a_second_home__c-cloneYes']//p[text()='Please select one']")
    private WebElement travelSecondHomeMenu;
    @FindBy(xpath = "//ul//p[text()='Yes']")
    private WebElement travelSecondHomeOptionYes;
    @FindBy(xpath = "//ul//p[text()='No']")
    private WebElement travelSecondHomeOptionNo;
    @FindBy(xpath = "//input[@value='Commercial']")
    private WebElement commertialOption;
    @FindBy(xpath = "//input[@value='Jet Card']")
    private WebElement jetCardOption;
    @FindBy(xpath = "//input[@value='Other Membership']")
    private WebElement otherMembershipOption;
    @FindBy(xpath = "//input[@value='Charter']")
    private WebElement charterOption;
    @FindBy(xpath = "//input[@value='Fractional']")
    private WebElement fractionalOption;
    @FindBy(xpath = "//input[@value='Whole Aircraft']")
    private WebElement wholeAirCraftOption;
    @FindBy(tagName = "textarea")
    private WebElement questionField;
    @FindBy(css = "div[class='close'] i[class='icon-close']")
    private WebElement closeIcon;



   public String getPageUrlEndpoint(){
       waitElement(typeOfTravelDropdownMenu);
       System.out.println(driver.getCurrentUrl().split("/")[3]);
       return driver.getCurrentUrl().split("/")[3];

   }

   public void chooseTypeOfTravel(String type){
       jsClick(typeOfTravelDropdownMenu);
       if(type.equals("Personal Travel")){
           jsClick(personalTravelMenuOption);
       }else if(type.equals("Busines Travel")){
           jsClick(businessTravelMenuOption);
       }else{
           jsClick(bothTravelMenuOption);
       }

   }

    public void chooseFlightsAYear(String option){

        jsClick(privateFlightsCountYearDropdownMenu);

        if(option.equals("0")){
            jsClick(optionZero);
        }else if(option.equals("1-5")){
            jsClick(optionOneToFive);
        }else if(option.equals("5-10")){
            jsClick(optionFiveToTen);
        }else{
            jsClick(optionTen);
        }

    }

    public void chooseTraveToSecondHome(String option){

        jsClick(travelSecondHomeMenu);

        if(option.equals("Yes")){
            jsClick(travelSecondHomeOptionYes);
        }else{
            jsClick(travelSecondHomeOptionNo);
        }

    }

    public void clickHowDoYouCurrentlyFlyCheckBoxes(String option){
        if(option.equals("Commercial")){
            jsClick(commertialOption);
        }else if(option.equals("Jet Card")){
            jsClick(jetCardOption);
        }else if(option.equals("Other Membership")){
            jsClick(otherMembershipOption);
        }else if(option.equals("Character")){
            jsClick(charterOption);
        }else if(option.equals("Fractional")){
            jsClick(fractionalOption);
        }else{
            jsClick(wholeAirCraftOption);
        }
    }



   public void fillOutTheForm( Map<String, String> map){

       typeTextToField(firstNameInput,map.get("First Name"));
       typeTextToField(lastNameInput,map.get("Last Name"));
       typeTextToField(emailInput,map.get("Email"));
       typeTextToField(phoneInput,map.get("Phone Number"));
       scrollToElement(privateFlightsCountYearDropdownMenu, driver);  //scroll down to make elements visible
       typeTextToField(companyNameInput,map.get("Company Name"));
       typeTextToField(addressInput,map.get("Street Address"));
       typeTextToField(cityInput,map.get("City"));
       typeTextToField(zipCodeInput,map.get("Zip Code"));
       typeTextToField(stateInput,map.get("State"));
       typeTextToField(countryInput,map.get("Country"));
       scrollToElement(commertialOption, driver);            //scroll down to make elements visible
       chooseFlightsAYear(map.get("Flights a year"));
       chooseTraveToSecondHome(map.get("Second Home"));       //scroll down to make elements visible
       scrollToElement(questionField, driver);
       clickHowDoYouCurrentlyFlyCheckBoxes(map.get("Currently Fly"));

   }

   public void clickOnCloseIcon(){
       click(closeIcon);
   }



}
