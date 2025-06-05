@nur
Feature: Profile page functionality
  User Story: As a user, I want to access my profile.

  Scenario Outline: Verify access to profile page with different user types
    Given the user logged in as "<userType>"
    When the user clicks on My Profile option under the User Menu
    And the user sees the "<userType>" email in the title
    And the user views the following options on My Profile page
      | General       |
      | Drive         |
      | Tasks         |
      | Calendar      |
      | Conversations |
    Then the user sees the "<userType>" email under the general tab
    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |







