package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PropertyDetail extends BasePage {

    public PropertyDetail(WebDriver driver){
        super(driver);
    }

    private static final By nameField = By.id("consulta_form_nombre");
    private static final By emailField = By.id("consulta_form_email");
    private static final By phoneNumberField = By.id("consulta_form_telefono");
    private static final By submitButton = By.cssSelector("button.g-recaptcha");
    private static final By emailErrorMessage = By.xpath("//*[@id='consulta_form_email_error']/span");
    private static final By nameErrorMesssage = By.xpath("//*[@id='consulta_form_nombre_error']/span");
    private static final By phoneErrorMessage = By.xpath("//*[@id='consulta_form_telefono_error']/span");

    public void setNameField(String name){
        driver.findElement(nameField).sendKeys(name);
    }

    public void setEmailField(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPhoneNumberField(String phoneNumber){
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public String getFirstAndLastNameFieldText(){
        return driver.findElement(nameField).getAttribute("value");
    }

    public String getEmailFieldText(){
        return driver.findElement(emailField).getAttribute("value");
    }

    public String getPhoneNumberFieldText(){
        return driver.findElement(phoneNumberField).getAttribute("value");
    }

    public void submitForm(){
        safeClick(submitButton);
    }

    public String getEmailErrorText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailErrorMessage)).getText();
    }

    public String getNameErrorText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(nameErrorMesssage)).getText();
    }

    public String getPhoneErrorText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(phoneErrorMessage)).getText();
    }



}
