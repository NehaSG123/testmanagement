Feature: Search and Add to Cart on Amazon

  @Regression
  Scenario: Search product and add to cart
    Given I am on Amazon homepage
    When I search for "laptop"
    And I select the first product from results
    And I add the product to the cart
    Then The cart should contain 1 item
