package tests;

import base.DriverManager;
import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.HomePage;

public class HomePageDef {

    TestBase base = new TestBase();
    DriverManager driverManager = DriverManager.getInstance();
    WebDriver driver = driverManager.getDriver();
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);

    @Given("User invokes the browser and navigates to home page")
    public void user_invokes_the_browser_and_navigates_to_home_page() {
       base.navigateToUrl();
    }

    @Then("User closes the browser")
    public void user_closes_the_browser() {
        driverManager.closeBrowser();
    }

    @Given("User is on Home page")
    public void user_is_on_home_page() {

        System.out.println("Title of the home page  " + driver.getTitle());
    }

    @When("User finds and validates the title {string}")
    public void user_finds_and_validates_the_title(String string) {
        System.out.println("This is +++++++++++++++++++++ "+ homePage.getPageWelcomeTitle());
        Assert.assertEquals( homePage.getPageWelcomeTitle(),"Flying, Personalized.");
    }

    @Then("User scrolls down to the text {string} and validates it")
    public void user_scrolls_down_to_the_text_and_validates_it(String string) {
        homePage.scrollToDiscoverThePossibilitiesText();
        System.out.println("This is +++++++++++++++++++++ "+ homePage.scrollToDiscoverThePossibilitiesText());
    }

    @Then("User scrolls to the button of the page and validates phone {string} email {string} and address {string}")
    public void user_scrolls_to_the_button_of_the_page_and_validates_phone_email_and_address(String phone, String email, String  address) {
        Assert.assertEquals(homePage.getPhoneNumber(), phone);
        Assert.assertEquals(homePage.getEmailAddress(), email);
//        Assert.assertEquals(landingPage.getAddress(), address);
        System.out.println("This is step 4" + homePage.getPhoneNumber() + homePage.getEmailAddress() + homePage.getAddress());
    }

    @Then("User scrolls to the top of the page")
    public void user_scrolls_to_the_top_of_the_page()  {
        homePage.scrollToFlyMenu();

    }

    @Then("Clicks Fly dropdown menu")
    public void clicks_Fly_dropdown_menu() {
        homePage.clickOnFlyMenu();
    }

    @Then("Clicks CORE MEMBERSHIP option from dropdown menu")
    public void clicks_CORE_MEMBERSHIP_option_from_dropdown_menu()  {
        homePage.clickOnCoreMembershipOptionInFlyMenu();

    }





}
