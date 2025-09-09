package seleniumtestng.validation;

import seleniumtestng.base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PropertyDetail;

public class ContactFormValidationTest extends BaseTests {

    /**
     * Verifies that the contact form displays a specific validation error
     * when a user enters an email with an invalid format. This test checks
     * the client-side validation rules for the email field.
     */
    @Test
    public void invalidEmailFormatValidationTest() {
        driver.get("https://osvaldovinelli.com.ar/propiedad/526204");
        PropertyDetail propertyDetail = new PropertyDetail(driver);

        String name = "Luca Vinelli";
        String invalidEmail = "invalid-email.com";
        String phone = "1112345678";

        propertyDetail.setNameField(name);
        propertyDetail.setEmailField(invalidEmail);
        propertyDetail.setPhoneNumberField(phone);
        propertyDetail.submitForm();

        String expectedErrorMessage = "Ingresá un email válido";
        String actualErrorMessage = propertyDetail.getEmailErrorText();

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage,
                "The email validation error message was not correct.");

    }

    /**
     * Verifies that the contact form displays the appropriate error messages
     * for all required fields when the form is submitted empty. This test
     * ensures that the mandatory field validation is working correctly.
     */
    @Test
    public void emptyRequiredFieldsValidationTest(){
        driver.get("https://osvaldovinelli.com.ar/propiedad/526204");
        PropertyDetail propertyDetail = new PropertyDetail(driver);

        propertyDetail.submitForm();

        Assert.assertEquals(propertyDetail.getNameErrorText(), "Ingresá tu nombre", "Error message for empty Name field is incorrect.");
        Assert.assertEquals(propertyDetail.getEmailErrorText(), "Ingresá un email válido", "Error message for empty Email field is incorrect.");
        Assert.assertEquals(propertyDetail.getPhoneErrorText(), "Ingresá tu teléfono", "Error message for empty Phone field is incorrect.");
    }

}