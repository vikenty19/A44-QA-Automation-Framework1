Feature: login tests
  Scenario Outline: login success
    Given I open browser
    When I open login page
    And  i enter valid email
    And I enter valid password
    And  I click Submit
    Then I am logged in
   Examples:


  Scenario:LoginWrongEmail
    Given I open browser
     When  I open login page
    And I enter wrong email
    And I enter valid password
    And I click Submit
    Then I am not logged in
