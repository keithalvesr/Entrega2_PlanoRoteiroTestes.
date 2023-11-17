Feature: User registration

  Scenario: Access registration form
    Given the user is not registered in kumu
    When he chooses the option to sign in
    Then he sees the form

  Scenario: Finishes registration
    Given the user is in the registration form
    When he fills all the information
    Then he authenticates himself in the app
