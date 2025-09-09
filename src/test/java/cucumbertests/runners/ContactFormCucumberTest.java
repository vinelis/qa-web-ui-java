package cucumbertests.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"cucumbertests.stepDefinitions", "cucumbertests.hooks"},
        plugin = {"pretty","summary","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        tags = "@smoke"
)
public class ContactFormCucumberTest extends AbstractTestNGCucumberTests {}

