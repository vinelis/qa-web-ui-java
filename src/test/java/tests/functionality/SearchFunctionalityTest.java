package tests.functionality;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchResultsPage;

public class SearchFunctionalityTest extends BaseTests {

    /**
     * Verifies that the application displays a clear warning message
     * when a property search returns no results. This test ensures
     * the system gracefully handles empty search outcomes.
     */
    @Test
    public void searchForNonExistentPropertyTest(){

        String operationtype = "Venta";
        String propertyType = "Departamentos";
        String locationType = "Arturo Segui";

        homePage.setOperationLocationAndPropertyTypeSuccessfully(operationtype, propertyType, locationType);
        SearchResultsPage searchResultsPage = homePage.clickSearchButton();

        String expectedMessage = "no se han encontrado resultados";
        String actualMessage = searchResultsPage.getNoResultsMessage();

        Assert.assertTrue(actualMessage.contains(expectedMessage), "The 'no results' warning message was not correct or not found.");

    }
}
