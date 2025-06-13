@profilePage
Feature: Profile page functionality
  User Story: As a user, I want to access my profile.

  Background:
    Given the user is on the login page

  @myProfile
  Scenario Outline: Verify access to options on My Profile page with different user types

    When the user logged in as "<userType>"
    And the user clicks on user Menu link
    And the user clicks on "My Profile" link under user Menu
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

  @generalTab
  Scenario Outline: Verify that all types of users can see their emails under the general tab

    When the user logged in as "<userType>"
    And the user clicks on user Menu link
    And the user clicks on "My Profile" link under user Menu
    And the user sees the "<userType>" email in the title
    Then the user sees the "<userType>" email under the general tab
    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |