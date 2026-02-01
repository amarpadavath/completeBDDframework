@smoke
Feature: Login functionality

  @chrome
  Scenario: Login on Chrome
    Given user launches the application
    When user enters valid username and password
    Then user should be logged in successfully

  @firefox
  Scenario: Login on Firefox
    Given user launches the application
    When user enters valid username and password
    Then user should be logged in successfully

  @edge
  Scenario: Login on Edge
    Given user launches the application
    When user enters valid username and password
    Then user should be logged in successfully
