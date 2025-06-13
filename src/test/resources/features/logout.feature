@logout
Feature: Users should be able to logout

  Scenario Outline: Verify user logout
    Given the user is on the login page
    When the user logged in as "<userType>"
    And the user clicks on user Menu link
    And the user clicks on "Log out" link under user Menu
    Then the user see authorization page

    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |