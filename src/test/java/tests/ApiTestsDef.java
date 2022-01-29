package tests;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import java.util.LinkedHashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;


public class ApiTestsDef {


    private Response response;
    private JsonPath jsonPath;
    private Map<String, String> result;

    @Given("User sends get request to {string}")
    public void user_sends_get_request_to(String url) {
         response = get(url);

    }

    @Given("User parses the response")
    public void user_parses_the_response() {
        jsonPath = response.body().jsonPath();
        System.out.println(jsonPath.getJsonObject("keys").toString());
    }

    @Then("User verifies that response has following values {string} and {string}")
    public void user_verifies_that_response_has_following_values_and(String string1, String string2) {
        String twitter = jsonPath.getJsonObject("keys.twitter").toString();
        String instagram = jsonPath.getJsonObject("keys.instagram").toString();
        System.out.println("==========================  "+jsonPath.getJsonObject("keys.twitter").toString());
        System.out.println("==========================  "+jsonPath.getJsonObject("keys.instagram").toString());
        Assert.assertEquals(twitter, string2 );
        Assert.assertEquals(instagram, string1 );

    }



    @When("Displays total number of keys field in the console")
    public void displays_total_number_of_keys_field_in_the_console() {
        jsonPath = response.body().jsonPath();
        Map<String, String> result = jsonPath.getJsonObject("keys");
        System.out.println(" Total number of data in keys field: "+ result.size());


    }

    @Then("User removes fields {string} {string} and {string}  and update email {string}")
    public void user_removes_fields_and_and_update_email(String googleTag, String mapBox, String footDisc, String email) throws JsonProcessingException{
        RequestSpecification request = given();
        jsonPath = response.body().jsonPath();
        Map<String, LinkedHashMap<String,String>> result = jsonPath.get();
        LinkedHashMap<String,String> keys = result.get("keys");
        for(Map.Entry<String,String> entry:keys.entrySet()){
            if(entry.getKey().equals(email)){
                entry.setValue("akbaryuldoshev@wheelsup.com");  // original  -   info@wheelsup.com
            }

            // This option in case if requirement was not to remove fields but remove only values
//            if(entry.getKey().equals(googleTag)||entry.getKey().equals(mapBox)||entry.getKey().equals(footDisc)){
//                  entry.setValue("")
//            }
            System.out.println("========================== This is Key: "+ entry.getKey());
            System.out.println("========================== This is Value: "+ entry.getValue());
        }
        // if requirement was not to remove given below fields all together then comment out below 3 lines and uncomment if statement in the loop
        keys.remove(googleTag);
        keys.remove(mapBox);
        keys.remove(footDisc);

        result.replace("keys",keys);
        ObjectMapper objectMapper = new ObjectMapper();
        String body = objectMapper.writeValueAsString(result);
        System.out.println("Final edited body data before submission"  +body);

        // server is not letting update the existing data I believe the endpoint is not mapped for post and put requests getting 405 status code
        // I put this line in case requirement was to update server values
        // If requirement was just to change the received json data it is already updated in the above code and printed out in the console
        int statusCode = request.body(body).put("https://wheelsup.com/_mock_/initial-data.json").getStatusCode();
        System.out.println("========================= "+statusCode+" =================================");
    }




}
