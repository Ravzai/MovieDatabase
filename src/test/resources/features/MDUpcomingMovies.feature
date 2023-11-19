Feature: Search for other options on the website

  Scenario: I see upcoming movies
    Given I am on the movie database website for upcoming movies
    And I navigate to movies
    When I click on upcoming movies
    Then I see all the upcoming movies