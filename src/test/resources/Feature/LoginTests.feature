Feature: Login Tests

  Scenario Outline: Login Success
    Given I open Login Page
    When I enter email
    And I enter password
    And I click submit
    Then I logged in
    Examples: