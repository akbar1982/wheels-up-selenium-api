package tests;

import base.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.CoreMembershipPage;

public class CoreMembershipDef {

    WebDriver driver = DriverManager.getInstance().getDriver();
    CoreMembershipPage coreMembershipPage = PageFactory.initElements(driver,CoreMembershipPage.class);


    @Then("In CORE MEMBERSHIP page user scrolls down to {string} section and validates the value")
    public void in_CORE_MEMBERSHIP_page_user_scrolls_down_to_section_and_validates_the_value(String string)  {
        coreMembershipPage.scrollToPrivateAviationHeader();

    }

    @Then("User validates {string} {string} and {string} sections")
    public void user_validates_and_sections(String shared, String shuttle, String hot) {
        Assert.assertEquals(coreMembershipPage.getSharedFlightsText(),shared);
        Assert.assertEquals(coreMembershipPage.getShuttleFlightsText(), shuttle);
        Assert.assertEquals(coreMembershipPage.getHotFlightsText(), hot);
        System.out.println("== "+coreMembershipPage.getSharedFlightsText()+" ==== "+coreMembershipPage.getShuttleFlightsText()+" ==== "+coreMembershipPage.getHotFlightsText());
    }

    @When("User scrolls down to the {string} section and clicks continue button")
    public void user_scrolls_down_to_the_section_and_clicks_continue_button(String string) {
        coreMembershipPage.scrollToLearnMore();
        coreMembershipPage.clickOnContinue();

    }
}
