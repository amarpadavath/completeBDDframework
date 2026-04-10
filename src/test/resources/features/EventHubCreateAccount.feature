Feature: Create account

  Scenario: Method1-direct
    Given launch url
    When User enters email "test@gmail.com" , password "test@gmail.com", confirmpassword "test@gmail.com"
    Then validation of user created success

  Scenario Outline: : Method2-Scenario Outline
    Given launch url
    When User enters "<email>" , "<password>",  "<confirmpassword>"
    Then validation of user created success

    Examples:
      | email           | password        | confirmpassword |
      | test@gmail.com  | test@gmail.com  | test@gmail.com  |
      | test1@gmail.com | test1@gmail.com | test1@gmail.com |

  Scenario: : Method 3.1-List of maps
    Given launch url
    When User enters details
      | email           | password        | confirmpassword |
      | test@gmail.com  | test@gmail.com  | test@gmail.com  |
      | test1@gmail.com | test1@gmail.com | test1@gmail.com |
    Then validation of user created success

  Scenario: : Method 3.2-List of list
    Given launch url
    When User enters detailss
      | test@gmail.com  | test@gmail.com  | test@gmail.com  |
      | test1@gmail.com | test1@gmail.com | test1@gmail.com |
    Then validation of user created success

  Scenario: : Method 4.1- config property1
    Given launch url
    When User enters using property file
      Then validation of user created success
