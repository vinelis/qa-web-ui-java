package base;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    private final int TIMEOUT = 10;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void safeClick(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        } catch (TimeoutException e) {
            throw new RuntimeException("No se pudo hacer click en el elemento: " + locator + " después de " + TIMEOUT + " segundos", e);
        }
    }

    public void safeClick(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (TimeoutException e) {
            throw new RuntimeException("No se pudo hacer click en el WebElement después de " + TIMEOUT + " segundos", e);
        }
    }
}