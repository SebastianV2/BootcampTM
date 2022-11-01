Feature: Search on OrangeHRM employee directory

  Background: The user must be logged in
    Given the user is on OrangeHRM homepage
    When he selects Directory option

  @Functional
  Scenario: Search an employee for name
    When he searches for an employees name
    Then he should see one search result