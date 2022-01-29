package tests;

import base.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.RequestInfoPage;

import java.util.Map;

public class RequestInfoDef {

    WebDriver driver = DriverManager.getInstance().getDriver();
    RequestInfoPage requestInfoPage = PageFactory.initElements(driver, RequestInfoPage.class);

    @When("Validates the link endpoint {string}")
    public void validates_the_link_endpoint(String expEndpoint) {
        Assert.assertEquals(requestInfoPage.getPageUrlEndpoint(),expEndpoint);
        System.out.println("=================== " + requestInfoPage.getPageUrlEndpoint());

    }

    @Then("User chooses {string} option from TYPE OF TRAVEL dropdown menu on REQUEST INFO page")
    public void user_chooses_option_from_TYPE_OF_TRAVEL_dropdown_menu_on_REQUEST_INFO_page(String string) {
        requestInfoPage.chooseTypeOfTravel(string);

    }

    @Then("User fills out all required fields with the data in given below table")
    public void user_fills_out_all_required_fields_with_the_data_in_given_below_table(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        Map<String, String> data = dataTable.asMap(String.class,String.class);
        requestInfoPage.fillOutTheForm( data);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("User clicks on close button in the corner of the page")
    public void user_clicks_on_close_button_in_the_corner_of_the_page() {
       requestInfoPage.clickOnCloseIcon();
    }

}
