Feature: Add product to cart and place order
   @test123
  Scenario Outline: User adds Brocolli to cart and completes checkout scenario outline
    Given user launches the GreenKart application
    When user searches for "<vegetable>"
    And user increases the quantity
    And user adds the product to cart
    And user proceeds to checkout
    And user places the order
    Then order should be placed successfully
    
    Examples:
    |vegetable|
    |Carrot|
    |Cucumber|