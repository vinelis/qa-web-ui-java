package seleniumtestng.base;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "Screenshot on failure", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    private static WebDriver getDriver(ITestResult iTestResult) {
        Object instance = iTestResult.getInstance();
        if (instance instanceof BaseTests) {
            WebDriver d = ((BaseTests) instance).driver;
            if (d != null) return d;
        }
        return DriverHolder.get();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Taking screenshot on failure for test " + getTestMethodName(iTestResult));
        WebDriver driver = getDriver(iTestResult);
        if (driver != null) {
            saveScreenshotPNG(driver);
        }
    }
}