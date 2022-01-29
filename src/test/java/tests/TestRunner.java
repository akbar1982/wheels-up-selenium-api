package tests;

import base.DriverManager;
import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.*;

import java.io.File;

//@Test
@CucumberOptions(

        features = "src/test/resources/features/",
        glue = {"tests"},
        dryRun = false,
        tags = {"@Smoke"},
        plugin = { "json:target/jsonReports/cucumber.json", "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"},
//        plugin = { "cucumberHooks.customReportListener","io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm" },
        monochrome = true )

public class TestRunner extends AbstractTestNGCucumberTests {

        TestBase base = new TestBase();
        DriverManager driver = DriverManager.getInstance();


        @BeforeSuite
        public void setUp() {

        }

        @BeforeTest
        public void runBefore(){
//                base.navigateToUrl();          //This is commented because of api test runtime browser should not start
        }
        @AfterTest
        public void runAfter(){
//                driver.closeBrowser();  //This is commented because of api test runtime browser should not start
        }

//        @AfterStep
//        public void runAfterStep(Scenario scenario) {
//                try {
//                        String screenshotName = scenario.getName().replaceAll("", "_");
//                        if (scenario.isFailed()) {
//                                TakesScreenshot ts = (TakesScreenshot) driver;
//                                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
//                                scenario.attach(screenshot, "img/png", screenshotName);
//                        }
//                } catch (Exception e) {
//                        e.printStackTrace();
//                }
//
//        }


        @AfterSuite
        public void endSuite() {


        }


//        @DataProvider(parallel = true)
//        @Override
//        public Object[][] scenarios() {
//                return super.scenarios();
//        }

//        @AfterStep
//        public void endstep(Scenario scenario) {
//                if (scenario.isFailed()) {
//                        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//                        scenario.attach(screenshot, "image/png", "screenshot");
//                }
//        }
}
