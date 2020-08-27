Feature: feature to test google search functionality

  Scenario: Validate google search is working
    Given open the browser
    And user should be on google search page
    When user enters a test in search box
    And hit Enter
    Then user is navigated to search results page
