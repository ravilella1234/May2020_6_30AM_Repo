Feature: Amazon Product Test

	@S1
  Scenario: Verifying login is successful with valid credientials
    Given user should be on login page
    When user fills username and password
    And Clicks on signIn button
    Then User is navigated to the main page

	@S2
  Scenario: To check product added to addToCart Page
    Given user is on products page
    When user should selects the product
    Then product should add to cartpage