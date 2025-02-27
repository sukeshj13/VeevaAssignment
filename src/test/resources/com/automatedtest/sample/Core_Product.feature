@CP
Feature: Core product feature test cases


  @CP1
  Scenario Outline: Search cucumber studio
    Given I navigates to core product website "https://www.nba.com/warriors"
    Then I select menu Shop and sub menu Men's

    When I search for "jackets" on the shopping page
    Then I capture title and price for products in CSV file

    Examples:
      | nbOfResultsToSearch |
      | 3 |
