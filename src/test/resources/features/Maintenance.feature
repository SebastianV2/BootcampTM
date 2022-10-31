Feature: Download employees info from OrangeHRM

  @Functional
  Scenario: : Download data from an employee
    Given the user is on OrangeHRM homepage
    And he selects Maintenance option
    When he enters the password and searches an employee data
    Then he can download the employee data