@E2E
Feature: End to End Test for DemoBlaze

  Scenario: User can place an order successfully
    Given I am on the home page
    And I login with valid credentials
    And I select the "Samsung Galaxy s7" product
    And I click the Add to cart button
    And I accept the alert
    And I click on the Cart link
    And I click the Place Order button
    And I fill in the order form with valid details
    And I click the Purchase button
    Then I should see a confirmation message with order details
    And I click the "OK" button on the confirmation dialog