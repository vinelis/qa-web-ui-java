package cucumbertests.stepDefinitions;

import cucumbertests.hooks.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertEquals;

import java.util.Map;

public class ContactFormHappySteps {

    private final Hooks hooks;

    public ContactFormHappySteps(Hooks hooks) {
        this.hooks = hooks;
    }

    @When("I fill the contact form with:")
    public void i_fill_the_contact_form_with(DataTable table) {
        Map<String, String> data = table.asMap(String.class, String.class);
        hooks.getPropertyDetail().setNameField(data.get("name"));
        hooks.getPropertyDetail().setEmailField(data.get("email"));
        hooks.getPropertyDetail().setPhoneNumberField(data.get("phone"));
    }

    @Then("the contact form fields should contain:")
    public void the_contact_form_fields_should_contain(DataTable table) {
        Map<String, String> expected = table.asMap(String.class, String.class);
        assertEquals(hooks.getPropertyDetail().getFirstAndLastNameFieldText(), expected.get("name"));
        assertEquals(hooks.getPropertyDetail().getEmailFieldText(), expected.get("email"));
        assertEquals(hooks.getPropertyDetail().getPhoneNumberFieldText(), expected.get("phone"));
    }
}
