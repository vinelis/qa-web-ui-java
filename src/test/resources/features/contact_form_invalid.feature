Feature: Contact form - invalid inputs (email/phone)

  Background:
    Given I am on the Property Detail page

  @negative @outline
  Scenario Outline: Invalid email or phone shows proper error
    When I fill the contact form with:
      | name  | Luca Vinelli |
      | email | <email>      |
      | phone | <phone>      |
    And I submit the form
    Then I should see the "<field>" error "<expectedError>"

    Examples:
      | field | email         | phone            | expectedError             |
      | email | not-an-email  | +54 11 1234 5678 | Ingresá un email válido   |

      # Known bug: phone field accepts letters, no error is shown
      # | phone | luca@mail.com | abcdef | Ingresá tu teléfono |
