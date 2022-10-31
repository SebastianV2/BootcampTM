Feature: Login on OrangeHRM page

  @Smoke @Functional
  Scenario: : Login
    Given the user navigates to OrangeHRM
    When he fills username and password
    Then he should see the homepage

  @Negative
  Scenario: Login with invalid credentials
    Given the user navigates to OrangeHRM
    When he fills username and password with wrong credentials
    Then he should see the wrong credentials error message

  @Negative
  Scenario: Login with empty username
    Given the user navigates to OrangeHRM
    When he fills only the password
    Then he should see the required field error message

  @Negative
  Scenario: Login with empty password
    Given the user navigates to OrangeHRM
    When he fills only the username
    Then he should see the required field error message

  @Functional
  Scenario: Logout
    Given the user is on OrangeHRM homepage
    When he close his session
    Then he should see the login page