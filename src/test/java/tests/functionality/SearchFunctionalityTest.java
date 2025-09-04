package tests.functionality;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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

    /**
     * Verifies that the search functionality works correctly for multiple
     * valid search criteria. This test is driven by the data provided
     * by the "validSearchDataProvider".
     * @param propertyType The type of property to search for (e.g., "Casa").
     * @param location The location to search in (e.g., "Lomas de Zamora").
     * @param operation The operation type (e.g., "Venta").
     * @param shouldFindResults TRUE if the search should return properties, FALSE otherwise.
     */
    @Test(dataProvider = "searchDataProvider")
    public void successfulSearchWithMultipleCriteriaTest(String propertyType, String location, String operation, boolean shouldFindResults){
        homePage.setOperationLocationAndPropertyTypeSuccessfully(operation, propertyType, location);
        SearchResultsPage searchResultsPage = homePage.clickSearchButton();

        boolean hasNoResultsMessage = searchResultsPage.isNoResultsMessageDisplayed();
        Assert.assertEquals(!hasNoResultsMessage, shouldFindResults,
                "Search expectation did not match the actual outcome for: " + propertyType + " in " + location);
    }

    @DataProvider(name = "searchDataProvider")
    public Object[][] getValidSearchData() {
        return new Object[][]{
                {"Casas", "Lomas de Zamora", "Venta", true},
                {"Departamentos", "Temperley", "Alquiler", false},
                {"Locales", "Banfield", "Venta", false}
        };
    }
}
