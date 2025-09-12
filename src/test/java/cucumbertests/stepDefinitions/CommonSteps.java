package cucumbertests.stepDefinitions;

import cucumbertests.hooks.Hooks;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.PropertyDetail;

public class CommonSteps {

    private final WebDriver driver;
    private final Hooks hooks;

    public CommonSteps(Hooks hooks) {
        this.hooks = hooks;
        this.driver = hooks.getDriver();
    }

    @Given("I am on the Property Detail page")
    public void i_am_on_the_property_detail_page() {
        driver.get("https://osvaldovinelli.com.ar/propiedad/526204");
        hooks.setPropertyDetail(new PropertyDetail(driver));
    }
}
