Feature: Drive page access
  As a user, I want to access the Drive page.

  @AccessDrv
  Scenario Outline: User views all required models on the drive page
    Given the user is on the login page
    When the user logged in as "<userType>"
    And Verify the users view the following 6 modules
    And  I navigate to the Drive page
    Then the user see "My drive"
    Then the user see "All document"
    Then the user see "Company drive"
    Then the user see "Sales and marketing"
    Then the user click on More option
    Then the user see "Top management document "
    Then the user see "Drive cleanup"

    Examples:
      | userType |
      | hr        |
      | helpdesk  |
      | marketing |
