$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/FutureTags/hooks.feature");
formatter.feature({
  "name": "Amazon Product Test",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verifying login is successful with valid credientials",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@S1"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user should be on login page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.HooksStepDefinatiion.user_should_be_on_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user fills username and password",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.HooksStepDefinatiion.user_fills_username_and_password()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Clicks on signIn button",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.HooksStepDefinatiion.Clicks_on_signIn_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User is navigated to the main page",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.HooksStepDefinatiion.user_is_navigated_to_the_main_page()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "To check product added to addToCart Page",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@S2"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on products page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.HooksStepDefinatiion.user_is_on_products_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should selects the product",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.HooksStepDefinatiion.user_should_selects_the_product()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "product should add to cartpage",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.HooksStepDefinatiion.product_should_add_to_cartpage()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});