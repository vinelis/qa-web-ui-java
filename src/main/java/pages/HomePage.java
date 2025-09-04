package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {

    private static final By operationTypeSelect = By.cssSelector("select[name='operacion[]']");
    private static final By propertyTypeSelect = By.cssSelector("select[name='tipoPropiedad[]']");
    private static final By locationTypeSelect = By.cssSelector("select[name='localidad[]']");
    private static final By searchBtn = By.xpath("//img[@alt='buscar']/ancestor::button[1]");

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void setOperationLocationAndPropertyTypeSuccessfully(String operationType, String propertyType, String locationType){
        new Select(driver.findElement(operationTypeSelect)).selectByVisibleText(operationType);
        new Select(driver.findElement(propertyTypeSelect)).selectByVisibleText(propertyType);
        new Select(driver.findElement(locationTypeSelect)).selectByVisibleText(locationType);
    }

    public SearchResultsPage clickSearchButton(){
        safeClick(driver.findElement(searchBtn));
        return new SearchResultsPage(driver);
    }






}
