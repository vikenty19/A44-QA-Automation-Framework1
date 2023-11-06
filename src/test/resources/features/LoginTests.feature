Feature: login tests
  Scenario: login success
    Given I open browser
    When I open login page
    And  i enter valid email
    And I enter valid password
    And  I click Submit
    Then I am logged in 