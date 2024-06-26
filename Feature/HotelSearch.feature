
Feature: booking.com site testing specific scenarios


  @hotelsSearch
Scenario: verify given hotel is present in the list
Given I am on default locations search result screen
Then I verify "Ela Ecoland Nature Retreat" is within the search result

  @maxAmount
  Scenario: check the hotel prices are below a certain amount
    Given I am on default locations search result screen
    Then I verify system displays all hotels within "5000" amount

  @starverify
  Scenario Outline: Verify user can only view the result by selected property class
    Given I am on default locations search result screen
    When I select option for stars as <stars>
    Then I verify system displays only <stars> hotels on search result
    Examples:
      | stars   |
      | 5 stars |


