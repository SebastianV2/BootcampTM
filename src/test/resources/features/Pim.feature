Feature: Transactions on PIM tab

  Background: The user must be logged in
    Given the user is on OrangeHRM homepage

  @Functional
  Scenario: Create an user without login info
    When he creates a basic user
    Then he should see all the info of the new user

  @Functional
  Scenario: Create an user with login info
    When he creates an user with login info
    Then he should see all the info of the new user

  @Negative
  Scenario: Create an user with empty name
    When he creates an user with empty name
    Then he should see the required field label

  @Functional
  Scenario: Search for employee Id
    When he searches an employee for his Id number
    Then he should see the info of the employee

  @Functional
  Scenario: Search a report
    When he searches for a report by name
    Then he should see the desired report

  @Functional
  Scenario: Edit the name of an employee
    When he edits the name of an employee
    Then he should see the new employees name