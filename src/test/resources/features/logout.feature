@logout
Feature: Users should be able to logout

  Scenario Outline: Verify user logout
    Given the user is on the login page
    When the user logged in as "<userType>"
    And the user clicks on profile link
    And the user clicks on logout link
    Then the user see authorization page

    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |