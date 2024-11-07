Feature: Login user

  Scenario Outline: Login with valid credentials
    Given User opens application URL
    And navigates om Login page
    When User enters valid email "amotooricap9@gmail.com"
    And Enters valid password "12345"
    And Click on login button
    Then User login successfully
    Examples:

  Scenario: Login with invalid credentials
    Given User opens application URL
    And navigates om Login page
    When User enters valid email "amotooricap93433@gmail.com"
    And Enters valid password "123456"
    And Click on login button
    Then User should get a warning message

  Scenario: Login with valid email and invalid password
    Given User opens application URL
    And navigates om Login page
    When User enters valid email "amotooricap9@gmail.com"
    And Enters invalid password "123456"
    And Click on login button
    Then User should get a warning message

  Scenario: Login with invalid email and valid password
    Given User opens application URL
    And navigates om Login page
    When User enters invalid email "amotooricap9343@gmail.com"
    And Enters valid password "12345"
    And Click on login button
    Then User should get a warning message

  Scenario: Login without email and password
    Given User opens application URL
    And navigates om Login page
    When User doesn't enter any credentials
    And Click on login button
    Then User should get a warning message



