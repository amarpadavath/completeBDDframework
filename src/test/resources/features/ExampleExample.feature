Feature: Example
@data
Scenario Outline: Create user
   
  Given User is on the User Creation page
  When User enters "<firstname>" "<lastname>" "<email>" "<password>"
  Then User should be created successfully

Examples:
        | firstname | lastname | email                | mobilenumber  |
      | Amar      | PV       | amar@test.com       | 1234567894  |
      | Rahul     | Kumar    | rahul@test.com      | 3216549874  |