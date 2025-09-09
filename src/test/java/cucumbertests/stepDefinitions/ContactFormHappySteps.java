package cucumbertests.stepDefinitions;

import cucumbertests.hooks.Hooks;
import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import pages.PropertyDetail;

import java.util.Map;

import static org.testng.Assert.assertEquals;

public class ContactFormHappySteps {

    private final WebDriver driver;
    private PropertyDetail propertyDetail;

    public ContactFormHappySteps(Hooks hooks) {
        this.driver = hooks.getDriver();
    }

    @Given("I am on the Property Detail page")
    public void i_am_on_the_property_detail_page() {
        driver.get("https://osvaldovinelli.com.ar/propiedad/526204");
        propertyDetail = new PropertyDetail(driver);
    }

    @When("I fill the contact form with:")
    public void i_fill_the_contact_form_with(DataTable table) {
        Map<String, String> data = table.asMap(String.class, String.class);
        propertyDetail.setNameField(data.get("name"));
        propertyDetail.setEmailField(data.get("email"));
        propertyDetail.setPhoneNumberField(data.get("phone"));}

    @Then("the contact form fields should contain:")
    public void the_contact_form_fields_should_contain(DataTable table) {
        Map<String, String> expected = table.asMap(String.class, String.class);
        assertEquals(propertyDetail.getFirstAndLastNameFieldText(), expected.get("name"));
        assertEquals(propertyDetail.getEmailFieldText(), expected.get("email"));
        assertEquals(propertyDetail.getPhoneNumberFieldText(), expected.get("phone"));
    }
}
