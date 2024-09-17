Feature: Subscription functionality

  Scenario: Verify the subscription message
    Given the user launches the browser and navigate to the URL
    And User clicks on the signup header link
    And the user enters the valid credentials "raviqa123@yopmail.com" and "Test@12345"
    When the user clicks on the login button
    Then the user should be navigated to home page
    When user goes to subscripton text box and enters email "raviqa123@yopmail.com"
   And user shold see the subscription success mesage