Feature: Add to cart

 Scenario: User adds Brocolli to cart and completes 
 
Given user launches the GreenKart
When user searches test for "Brocolli"
And user increases the quant
 And user adds the product to
  And user proceeds to
   And user places the
    Then order should be placed