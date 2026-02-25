Feature: User Management
@data
  Scenario: Create multiple users
    Given User is on the User Creation page
    When User enters the following details
      | firstname | lastname | email                | mobilenumber  |
      | Amar      | PV       | amar@test.com       | 1234567894  |
      | Rahul     | Kumar    | rahul@test.com      | 3216549874  |
    Then User should be created successfully