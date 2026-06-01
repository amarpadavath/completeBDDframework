Feature: Flight booking

  Scenario: Valid login with correct credentials
    Given user login on flight websites
    When user search the flights
    Then Validation of resutls
