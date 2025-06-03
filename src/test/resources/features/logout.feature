@logout
Feature: Users should be able to logout

  @wip
  Scenario Outline: Verify user logout
    Given the user logged in as "<userType>"
    When the user clicks on profile link
    And the user clicks on logout link
    Then the user see autorization page

    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |