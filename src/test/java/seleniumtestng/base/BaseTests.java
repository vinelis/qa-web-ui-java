package seleniumtestng.base;

import config.TestConfig;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

public class BaseTests {

    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeMethod
    public void setUp(){
        String browser  = System.getProperty("browser", "chrome");
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));

        if ("chrome".equalsIgnoreCase(browser)) {
            io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
            org.openqa.selenium.chrome.ChromeOptions options = new org.openqa.selenium.chrome.ChromeOptions();
            if (headless) {
                options.addArguments("--headless=new");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-gpu");
            }
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        if (!headless) {
            driver.manage().window().maximize();
        }
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
