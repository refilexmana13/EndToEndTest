@Login
Feature: Login

  Scenario: Login with valid credentials
    Given I am on the home page
    And I click the login link
    When I enter valid username and password
    And I click the login button
    Then I should see text "Welcome testingrefi"