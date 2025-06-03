@nur
Feature: Profile page functionality
  User Story: As a user, I want to access my profile.

  @hr
  Scenario:Log in as hr user
    Given user logs in as hr user
    When user clicks on My Profile option under the user menu.
    And user sees his her hr email in the title.
    And user views the following options on My Profile page
      | General       |
      | Drive         |
      | Tasks         |
      | Calendar      |
      | Conversations |
    Then user sees his her hr email under the general tab

  @helpdesk
  Scenario:Log in as helpdesk user
    Given user logs in as helpdesk user
    When user clicks on My Profile option under the user menu.
    And user sees his her helpdesk email in the title.
    And user views the following options on My Profile page
      | General       |
      | Drive         |
      | Tasks         |
      | Calendar      |
      | Conversations |
    Then user sees his her helpdesk email under the general tab

  @marketing
  Scenario:Log in as marketing user
    Given user logs in as marketing user
    When user clicks on My Profile option under the user menu.
    And user sees his her marketing email in the title.
    And user views the following options on My Profile page
      | General       |
      | Drive         |
      | Tasks         |
      | Calendar      |
      | Conversations |
    Then user sees his her marketing email under the general tab



