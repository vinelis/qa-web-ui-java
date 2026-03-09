package cucumbertests.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.PropertyDetail;

public class Hooks {

    private WebDriver driver;
    private PropertyDetail propertyDetail;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        ChromeOptions options = new ChromeOptions();
        if (headless) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
        }
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        seleniumtestng.base.DriverHolder.set(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            seleniumtestng.base.DriverHolder.remove();
            driver.quit();
        }
    }

    public WebDriver getDriver() { return driver; }

    public PropertyDetail getPropertyDetail() { return propertyDetail; }
    public void setPropertyDetail(PropertyDetail propertyDetail) { this.propertyDetail = propertyDetail; }
}
