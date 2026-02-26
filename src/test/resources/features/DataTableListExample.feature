Feature: Product Search

  Scenario: Search multiple products
    Given User is on the Home page
    When User searches for below products
      | Laptop   |
      | Mobile   |
      | Headphone|
    Then Search results should be displayed