Feature: User Signup and Account Management

  @NewUserRegistration
  Scenario: New User Signup
    Given the user launches the browser and navigate to the URL
    Then the home page should be visible successfully
    When the user clicks on the Signup/Login button
    Then they should see 'New User Signup!' on the page
    When the user enters their name and email address
    And clicks the Signup button
    Then user should see 'ENTER ACCOUNT INFORMATION' on the page
    When the user fills required informations for registration
    And clicks the Create Account button
    Then they should see ACCOUNT CREATED! on the page
    When the user clicks the Continue button
    Then they should see Logged in as username
    When the user clicks the Delete Account button
    Then they should see ACCOUNT DELETED! on the page
    And they click the Continue button

  @ExistingUserRegistration
  Scenario: Register user with existing credentials
    Given the user launches the browser and navigate to the URL
    Then the home page should be visible successfully
    When the user clicks on the Signup/Login button
    Then they should see 'New User Signup!' on the page
    When the user enters their name and email address "Ravi" and "raviqa123@yopmail.com"
    And clicks the Signup button
    Then they should see the error message "Email Address already exist!"
