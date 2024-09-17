
Feature: Products Functionality

  @ProductDetail
  Scenario: Verify the view product functionality for any one product
    Given the user launches the browser and navigate to the URL
    And User clicks on the signup header link
    And the user enters the valid credentials "raviqa123@yopmail.com" and "Test@12345"
    When the user clicks on the login button
    Then the user should be navigated to home page
    When the user clicks on the Products button
    Then they should be navigated to the ALL PRODUCTS page successfully
    And the products list should be visible
    When user clicks on the View Product link of the MenTshirt
    Then the user should be landed on the MenTshirt detail page
    And the user verifies the below details
      | Product Name | Men Tshirt              |
      | Category     | Category: Men > Tshirts |
      | Price        | Rs. 400                 |
      | Availability | In Stock                |
      | Condition    | New                     |
      | Brand        | H&M                     |
