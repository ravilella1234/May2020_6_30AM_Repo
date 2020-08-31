Feature: To Test LoginFunctionality

  Scenario Outline: To check login is Successful with valid credientials
    Given Open the browser by user
    And User is on login page
    When enter <username> and <password>
    And user should click on login
    Then User should navigated to home page

    Examples: 
      | username  | password |
      | ravilella |    12345 |
      | sai       |    12345 |
      | kiran     |    12345 |
