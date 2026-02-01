Feature: Login functionality

  Scenario: Valid login with correct credentials
    Given user is on login page
    When user logs in with valid username and password
    Then user should see successful login message
