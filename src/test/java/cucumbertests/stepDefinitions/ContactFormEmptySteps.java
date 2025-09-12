package cucumbertests.stepDefinitions;

import cucumbertests.hooks.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.util.Map;

import static org.testng.Assert.assertEquals;

public class ContactFormEmptySteps {

    private final Hooks hooks;

    public ContactFormEmptySteps(Hooks hooks) {
        this.hooks = hooks;
    }

    @When("I submit the form without filling any fields")
    public void i_submit_the_form_without_filling_any_fields() {
        hooks.getPropertyDetail().submitForm();
    }

    @Then("I should see error messages:")
    public void i_should_see_error_messages(DataTable table) {
        Map<String, String> expected = table.asMap(String.class, String.class);

        assertEquals(hooks.getPropertyDetail().getNameErrorText(),  expected.get("name"));
        assertEquals(hooks.getPropertyDetail().getEmailErrorText(), expected.get("email"));
        assertEquals(hooks.getPropertyDetail().getPhoneErrorText(), expected.get("phone"));
    }
}
