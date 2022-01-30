package tests;

import base.DriverManager;
import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.io.File;


@CucumberOptions(

        features = "src/test/resources/features/",
        glue = {"tests"},
        dryRun = false,
        tags = {"@Smoke"},
        plugin = {"html:target/cucumber-html-report",
                "json:target/cucumber.json",
                "pretty:target/cucumber-pretty.txt","usage:target/cucumber.json", "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"},

        monochrome = true )

public class TestRunner extends AbstractTestNGCucumberTests {

        TestBase base = new TestBase();
        DriverManager driver = DriverManager.getInstance();


        @BeforeSuite
        public void setUp() {

        }

        @BeforeTest
        public void runBefore(){

        }
        @AfterTest
        public void runAfter(){

        }

//        @AfterStep
//        public void runAfterStep(Scenario scenario) {
//                try {
//
//                        if (scenario.isFailed()) {
//                          Allure.addAttachment("screenshot",new ByteArrayInputStream(((TakesScreenshot)driver.getDriver()).getScreenshotAs(OutputType.BYTES)));
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
