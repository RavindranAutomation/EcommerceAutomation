Feature: Login Feature

  Scenario: Verify the login functionality with valid credentials
    Given User launches the application
    And the user enters the valid credentials "raviqa123@yopmail.com" and "Test@12345"
    When the user clicks on the login button
    Then the user should able to see the logout account link

  Scenario: Verify the login functionality with invalid credentials
    Given User launches the application
    And the user enters the invalid credentials "raviqa123@hotmail.com" and "@Test2w"
    When the user clicks on the login button
    Then the user should able to see invalid login error message
