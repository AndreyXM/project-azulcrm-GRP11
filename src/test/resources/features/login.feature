@login
Feature: Users should be able to login


  Scenario Outline: Verify login with different user types
    Given the user logged in as "<userType>"
    Then the user see dashboard page

Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |


