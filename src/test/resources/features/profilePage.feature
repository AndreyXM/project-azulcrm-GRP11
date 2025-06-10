@profilePage
Feature: Profile page functionality
  User Story: As a user, I want to access my profile.

  Scenario Outline: Verify access to options on My Profile page with different user types
    Given the user is on the login page
    When the user logged in as "<userType>"
    And the user clicks on My Profile option under the User Menu
    Then the user views the following options on My Profile page
      | General       |
      | Drive         |
      | Tasks         |
      | Calendar      |
      | Conversations |
    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |

  Scenario Outline: Verify that all types of users can see their emails under the general tab
    Given the user is on the login page
    When the user logged in as "<userType>"
    And the user clicks on My Profile option under the User Menu
    Then the user sees the "<userType>" email under the general tab
    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |






