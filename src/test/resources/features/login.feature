@login
Feature: Users should be able to login

  Background:
    Given the user is on the login page

  Scenario Outline: Verify login with "<userType>" user types
    When the user logged in as "<userType>"
    Then the user see dashboard page

    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |

  Scenario Outline: Attempting Login with Invalid Credentials: username "<userName>" and password "<password>"
    When the user enters an username "<userName>" and password "<password>"
    Then the login should failed
    And an error message should be displayed

    Examples:
      | userName        | password    |
      | invalidUserName | invalidPass |
      | invalidUserName |             |
      |                 | invalidPass |
      |                 |             |