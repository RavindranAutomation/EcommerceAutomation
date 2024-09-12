Feature: Contact US

  Scenario: Contact us form submission
    Given User launches the application
    And the user enters the valid credentials "raviqa123@yopmail.com" and "Test@12345"
    When the user clicks on the login button
    Then the user should able to see the logout account link
    When the user clicks on the Contact Us link
    Then the user should be rediected to contact us page
    And the verifies the feedback mail id
    And User enters the below details
      | Name    | Ravindran                                             |
      | Email   | raviqa123@yopmail.com                                 |
      | Subject | Return Order                                          |
      | Message | Kindly create a return order for the attached product |
    And the user attaching the product image
    And the user clicks on the submit button
    Then the user should able to see the details submitted message
