Feature: Add product to cart and place order
   @test123
  Scenario: User adds Brocolli to cart and completes checkout
    Given user launches the GreenKart application
    When user searches for "Brocolli"
    And user increases the quantity
    And user adds the product to cart
    And user proceeds to checkout
    And user places the order
    Then order should be placed successfully