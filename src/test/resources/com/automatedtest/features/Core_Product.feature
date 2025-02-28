@CP
Feature: Core product feature test cases


  @CP1
  Scenario: Search for products on the shopping page
    Given I navigates to core product website "https://www.nba.com/warriors"
    Then I select menu Shop and sub menu Men's

    When I search for "jackets" on the shopping page
    Then I capture title and price for products in CSV file

  @CP2
  Scenario: Search for products on the shopping page
    Given I navigates to core product website "https://www.nba.com/warriors"
    Then I select News and features on home page
    And I capture total number of video Feed present on the page