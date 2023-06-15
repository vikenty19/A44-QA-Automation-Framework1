Feature: Login Tests

  Scenario Outline: Login Success
    Given I open browser
    When i open login page
    When I enter email
    And I enter password
    And I click submit
    Then I logged in
    Examples: