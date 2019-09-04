$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Login.feature");
formatter.feature({
  "name": "user Login into the Global App",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Valid user and Password",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is at home page",
  "keyword": "Given "
});
formatter.match({
  "location": "GUIStepDefination.user_is_at_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user able to enter valid username and password",
  "keyword": "Then "
});
formatter.match({
  "location": "GUIStepDefination.user_able_to_enter_valid_user_name_and_password()"
});
formatter.result({
  "status": "passed"
});
});