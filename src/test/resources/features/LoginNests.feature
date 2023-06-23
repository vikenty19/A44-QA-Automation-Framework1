Feature: Login Tests
  Scenario: Login success

   Given I open Login page
  And I enter email
    And  I enter password
    And i click submit
    Then I logged in

