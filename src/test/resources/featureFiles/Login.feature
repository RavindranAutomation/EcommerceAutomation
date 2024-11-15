Feature: Login functionality

  Background: 
    Given User navigates to login page

  Scenario: Login with valid credentials
    When User enters valid email address "ravindrann10898@gmail.com" into email field
    And User enters valid password "Test@12345" into password field
    And User clicks on Login button
    Then User should get successfully logged in
    And User should logout
    
  Scenario: Login with invalid credentials
    When User enters valid email address "ravinrdrann898@gmail.com" into email field
    And User enters valid password "Test@12345" into password field
    And User clicks on Login button
    Then User should not get successfully logged in
