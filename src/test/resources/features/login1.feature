@smoke @login
Feature: Login functionality

  @smoke @test @edge @edge 
  Scenario: Valid login with correct credentials
    Given user is on login page
    When user logs in with valid username and password
    Then user should see successful login message
    
    

  @regression @test @chrome
  Scenario: Invalid login
    Given user is on login page
    When user logs in with invalid username and password
    Then user should see error message
