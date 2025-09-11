Feature: Contact form validation - empty required fields
  As a visitor
  I want to submit the contact form without filling any fields
  So that I can see proper validation error messages

  Background:
    Given I am on the Property Detail page

  @negative
  Scenario: Submit form with empty required fields
    When I submit the form without filling any fields
    Then I should see error messages:
      | field | errorMessage            |
      | name  | Ingresá tu nombre       |
      | email | Ingresá un email válido |
      | phone | Ingresá tu teléfono     |
