Feature: Capture whole page
  Scenario Outline: Capture whole pgae with all accordions opened
    Given I navigate to below page "<url>"
    When I open all the accoridon
    Then I capture page from top to bottom
    Examples:
    |url|
    |https://www.santander.co.uk/personal/credit-cards/everyday-credit-card|