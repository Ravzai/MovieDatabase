Feature: Search for other options on the website

  Scenario: I see upcoming movies
    Given I am on the movie database website for upcoming movies
    And I click on movies
    When I navigate to upcoming movies
    Then I see all the upcoming movies
