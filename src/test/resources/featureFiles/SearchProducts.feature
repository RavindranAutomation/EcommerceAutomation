Feature: Search functionality

  Scenario: Verifing search functionality of the Pure Cotton V-Neck T-Shirt
    Given the user launches the browser and navigate to the URL
    And User clicks on the signup header link
    And the user enters the valid credentials "raviqa123@yopmail.com" and "Test@12345"
    When the user clicks on the login button
    Then the user should be navigated to home page
    And the user clicks on the Products button
    Then they should be navigated to the ALL PRODUCTS page successfully
    When user search the 'Pure Cotton V-Neck T-Shirt' product
    Then user should see the first product results

