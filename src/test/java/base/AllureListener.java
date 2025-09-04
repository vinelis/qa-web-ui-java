package base;

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

    @Attachment(value = "Screenshot", type = "image/png")
    public void saveScreenshotPNG(WebDriver driver) {
        ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Taking screenshot on failure for test " + getTestMethodName(iTestResult));
        Object testClass = iTestResult.getInstance();
        WebDriver driver = ((BaseTests) testClass).driver;
        if (driver != null) {
            saveScreenshotPNG(driver);
        }
    }
}