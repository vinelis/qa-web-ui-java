package cucumbertests.hooks;

import drivers.DriverHolder;
import drivers.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import pages.PropertyDetail;

public class Hooks {

    private WebDriver driver;
    private PropertyDetail propertyDetail;

    @Before
    public void setUp() {
        driver = WebDriverFactory.createDriver();
        DriverHolder.set(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            DriverHolder.remove();
            driver.quit();
        }
    }

    public WebDriver getDriver() { return driver; }

    public PropertyDetail getPropertyDetail() { return propertyDetail; }
    public void setPropertyDetail(PropertyDetail propertyDetail) { this.propertyDetail = propertyDetail; }
}
