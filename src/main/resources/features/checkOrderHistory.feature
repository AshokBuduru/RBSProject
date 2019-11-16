@regression
Feature: Verify user place order and update personal details

  @placeOrder
  Scenario Outline: Check user can place order and verify order history
    Given I navigate to application "<applicationURL>"
    And I click on sign in link
    When I enter username and password
    And I click on signin button
    And I click on Tshirt menu
    And I select unique Tshirt and add to cart
    And I click on proceed to checkout in summary page
    And I click on proceed to checkout in address page
    And I click on proceed to checkout in shipping page
    Then I complete payment using pay by bank wire method
    And I click on back to order link
    And I check order placed successfully for "<price>"
      Examples:
      |applicationURL|price|
      |http://automationpractice.com|18.51|

    @updatePersonalDetails
    Scenario Outline: Check user can update personal details
      Given I navigate to application "<applicationURL>"
      And I click on sign in link
      When I enter username and password
      And I click on signin button
      And I click on myaccount link
      And I click on personal details link
      Then I update first name to "<updateName>"
      And I click on save button
      Examples:
        |applicationURL|updateName|
        |http://automationpractice.com|Ashok|