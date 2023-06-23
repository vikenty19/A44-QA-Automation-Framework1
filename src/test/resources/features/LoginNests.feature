Feature: Login Tests
  Scenario: Login success

   Given I open Login page
    And I enter email
    And  I enter password
    And i click submit
    Then I logged in

Scenario: Wrong password test
  Given I open Login page
  And I enter email
  And  I enter a wrong password
  And i click submit
  Then I'm not logged in