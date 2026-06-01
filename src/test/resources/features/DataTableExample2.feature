Feature: Data table
Scenario: Login users

Given I have usernames
  | username |
  | Amar     |
  | John     |
  | David    |
  
  Scenario: User details

Given I have user data
  | Name  | Age | City   |
  | Amar  | 30  | Kochi  |
  | John  | 25  | Delhi  |
  | David | 28  | Mumbai |
  
  Scenario: User information

Given user details
  | Username | Amar          |
  | Password | Test123       |
  | Role     | Admin         |
  
  Scenario: Multiple users

Given user records
  | Username | Password | Role  |
  | Amar     | Test123  | Admin |
  | John     | Pass123  | User  |
  | David    | Demo123  | User  |