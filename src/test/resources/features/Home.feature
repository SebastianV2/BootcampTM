Feature: Check options on dropdown profile

  Background: The user must be logged in
    Given the user is on OrangeHRM homepage

  @Functional
  Scenario: Check about option
    When he gets into about option
    Then he should see about information of the page

  @Functional
  Scenario: Check support option
    When he gets into support option
    Then he should see the customer support information