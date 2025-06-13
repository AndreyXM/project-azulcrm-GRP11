Feature:Activity Stream Page Options

  Agile Story: As a user, I should be able to see all the options on the Activity stream page.

  Background:
    Given the user is on the login page

  @ActStream
  Scenario Outline: 1. Verify that user view the following options on Activity stream page.

    When the user logged in as "<userType>"
    And the user navigates to the Activity Stream page
    And the Activity Stream page is loaded
    Then the user should see the following options

      | MESSAGE |
      | TASK    |
      | EVENT   |
      | POLL    |
      | MORE    |

    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |

  @ViewOptions
  Scenario Outline: Verify the users view the following 4 options under the MORE tab.

    When the user logged in as "<userType>"
    And the user navigates to the Activity Stream page
    And the Activity Stream page is loaded
    And the user clicks on the MORE tab
    Then the user should see the following options:

      | File         |
      | Appreciation |
      | Announcement |
      | Workflow     |

    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |