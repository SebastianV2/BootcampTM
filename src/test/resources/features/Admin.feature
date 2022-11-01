Feature: Transactions on Admin tab

  Background: The user must be logged in
    Given the user is on OrangeHRM homepage
    When he selects Admin option

  @Functional
  Scenario: Search Admin by username
    When he searches an Admin by username
    Then he should see all the info of the admin

  @Functional
  Scenario: Search Admin by employee name
    When he searches an Admin by employee name
    Then he should see all the info of the admin