Feature: Contact form validation (Happy path only)

  Background:
    Given I am on the Property Detail page

  @smoke
  Scenario: Submit form with valid data (without real submit)
    When I fill the contact form with:
      | name    | Luca Vinelli      |
      | email   | luca@vinelli.com  |
      | phone   | +54 11 1234 5678  |
    Then the contact form fields should contain:
      | name    | Luca Vinelli      |
      | email   | luca@vinelli.com  |
      | phone   | +54 11 1234 5678  |
