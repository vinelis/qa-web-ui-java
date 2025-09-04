package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage {

    private static final By firstHouseBtn = By.xpath("//p[@class='titulo' and contains(text(), 'Excelente Lote')]");
    private static final By noResultMessage = By.cssSelector("p.alert__title");

    public SearchResultsPage(WebDriver driver){
        super(driver);
    }

    public PropertyDetail clickToPropertyDetail(){
        safeClick(firstHouseBtn);
        return new PropertyDetail(driver);
    }

    public String getNoResultsMessage(){
        return driver.findElement(noResultMessage).getText();
    }

    public boolean isNoResultsMessageDisplayed() {
        try {
            return driver.findElement(noResultMessage).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

}
