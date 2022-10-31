Feature: Review and edit an employee personal information

  Background: The user must be logged in
    Given the user is on OrangeHRM homepage
    When he selects My info option

  @Functional
  Scenario: Check employee name
    When he reviews his personal information in the page
    Then he should see his name on top of the form

  @Functional
  Scenario: Add new Emergency contact
    When he adds a new emergency contact
    Then he should see the new contact in the list

  @Functional
  Scenario: Delete Emergency contact
    When he deletes an emergency contact
    Then he should see the new contact in the list