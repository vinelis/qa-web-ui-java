package cucumbertests.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PropertyDetail;

public class Hooks {

    private WebDriver driver;
    private PropertyDetail propertyDetail;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    public WebDriver getDriver() { return driver; }

    public PropertyDetail getPropertyDetail() { return propertyDetail; }
    public void setPropertyDetail(PropertyDetail propertyDetail) { this.propertyDetail = propertyDetail; }
}
