Feature: Sort Functionality

  Background: User is login to site
    Given User opens SauceDemo site
    When User enters valid credentials
    Then User will be navigated to Dashboard

  @Failed
  Scenario: Test will fail
    When User select sort via "az"
    Then Items will be sorted in descending order
    And User closes the browser

  @Regression
  Scenario: Should be able to sort in ascending order
    When User select sort via "az"
    Then Items will be sorted in ascending order
    And User closes the browser

  @Regression
  Scenario: Should be able to sort in descending order
    When User select sort via "za"
    Then Items will be sorted in descending order
    And User closes the browser
