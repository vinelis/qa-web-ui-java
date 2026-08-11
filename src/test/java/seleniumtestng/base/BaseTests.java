package seleniumtestng.base;

import config.TestConfig;
import drivers.DriverHolder;
import drivers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

public class BaseTests {

    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.createDriver();
        driver.get(TestConfig.BASE_URL);
        DriverHolder.set(driver);
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null) {
            DriverHolder.remove();
            driver.quit();
        }
    }

}
