Feature: Cart Functionality
Scenario: Verify the cart functionality

Given the user launches the browser and navigate to the URL
    And User clicks on the signup header link
    And the user enters the valid credentials "raviqa123@yopmail.com" and "Test@12345"
    When the user clicks on the login button
    When the user clicks on the Products button
    Then they should be navigated to the ALL PRODUCTS page successfully
    And the user adds the Blue top to cart
    When user clicks on Cart header link
    Then Shopping cart page should be displayed
    When user click on the Proceed to checkout button
    And checkout page should be dispalyed
    And user verfifies the cart items and total amount "Rs. 1000"