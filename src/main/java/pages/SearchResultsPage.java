package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage {

    private static final By firstHouseBtn = By.xpath("//p[@class='titulo' and contains(text(), 'Excelente Lote')]");

    public SearchResultsPage(WebDriver driver){
        super(driver);
    }

    public PropertyDetail clickToPropertyDetail(){
        safeClick(firstHouseBtn);
        return new PropertyDetail(driver);
    }

}
