package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultsPage extends BasePage {

    private static final By firstPropertyCard = By.cssSelector("#prop-list a.prop-card");
    private static final By resultsContainer = By.id("prop-list");
    private static final By noResultMessage = By.cssSelector("p.alert__title");

    public SearchResultsPage(WebDriver driver){
        super(driver);
    }

    public PropertyDetail clickToPropertyDetail(){
        safeClick(firstPropertyCard);
        return new PropertyDetail(driver);
    }

    public String getNoResultsMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(noResultMessage)).getText();
    }

    public boolean hasNoResultsMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(resultsContainer));
        return !driver.findElements(noResultMessage).isEmpty();
    }

}
