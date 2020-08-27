$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Features/GoogleSearch.feature");
formatter.feature({
  "name": "feature to test google search functionality",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Validate google search is working",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "open the browser",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.GoogleStepDefenition.open_the_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should be on google search page",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.GoogleStepDefenition.user_should_be_on_google_search_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters a test in search box",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.GoogleStepDefenition.user_enters_a_test_in_search_box()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "hit Enter",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.GoogleStepDefenition.hit_Enter()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user is navigated to search results page",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.GoogleStepDefenition.user_is_navigated_to_search_results_page()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:src/test/resources/Features/login.feature");
formatter.feature({
  "name": "Test login Functionality",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@smokeFeature"
    }
  ]
});
formatter.scenario({
  "name": "Check login is successful with valid credientials",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smokeFeature"
    },
    {
      "name": "@smoketest"
    }
  ]
});
formatter.step({
  "name": "user is on login page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.LoginSteps.user_is_on_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters username and password",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.LoginSteps.user_enters_username_and_password()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clicks on login button",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.LoginSteps.clicks_on_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user is navigated to the home page",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.LoginSteps.user_is_navigated_to_the_home_page()"
});
formatter.result({
  "status": "passed"
});
});