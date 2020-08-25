Feature: Test login Functionality

  Scenario: Check login is successful with valid credientials
    Given user is on login page
    When user enters username and password
    And clicks on login button
    Then user is navigated to the home page

  Scenario Outline: Check login is successful with valid credientials
    Given user is on login page
    When user enters <username> and <password>
    And clicks on login button
    Then user is navigated to the home page

    Examples: 
      | username | password |
      | ravi     | ravi1234 |
      | sai      | sai1234  |
