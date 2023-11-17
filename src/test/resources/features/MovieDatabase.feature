Feature: Movie Database Search

  Scenario: Searching for a movie
    Given I am on the movie database website
    And I search for Titanic
    When I click the search button
    Then The first search result should be Titanic
