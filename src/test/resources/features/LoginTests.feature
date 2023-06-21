Feature: Login Tests

  Scenario: Login Success
    Given i open login page
    When I enter email
    And I enter password
    And I click submit
    Then I logged in


  Scenario : Wrong password test
    Given i open login page
    When I enter email
    And I enter wrong password
    And I click submit
    Then I'm no logged in