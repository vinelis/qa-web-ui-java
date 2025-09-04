package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PropertyDetail extends BasePage {

    public PropertyDetail(WebDriver driver){
        super(driver);
    }

    private static final By nameField = By.id("consulta_form_nombre");
    private static final By emailField = By.id("consulta_form_email");
    private static final By phoneNumberField = By.id("consulta_form_telefono");

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
}
