Feature: Search on OrangeHRM employee directory

  @Functional
  Scenario: : Search an employee for name
    Given the user is on OrangeHRM homepage
    And he selects Directory option
    When he searches for an employees name
    Then he should see one search result