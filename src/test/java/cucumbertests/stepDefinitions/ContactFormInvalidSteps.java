package cucumbertests.stepDefinitions;

import cucumbertests.hooks.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertEquals;

public class ContactFormInvalidSteps {

    private final Hooks hooks;

    public ContactFormInvalidSteps(Hooks hooks) {
        this.hooks = hooks;
    }

    @When("I submit the form")
    public void i_submit_the_form() {
        hooks.getPropertyDetail().submitForm();
    }

    @Then("I should see the {string} error {string}")
    public void i_should_see_the_field_error(String field, String expectedError) {
        switch (field) {
            case "email" -> assertEquals(hooks.getPropertyDetail().getEmailErrorText(), expectedError);
            case "phone" -> assertEquals(hooks.getPropertyDetail().getPhoneErrorText(), expectedError);
            case "name"  -> assertEquals(hooks.getPropertyDetail().getNameErrorText(), expectedError);
            default -> throw new IllegalArgumentException("Unknown field: " + field);
        }
    }
}
