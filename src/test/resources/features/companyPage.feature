Feature: Company Page Functionality


  Scenario Outline: User should be able to access the company page
    Given the user is on the login page
    Then user logged in as a "<userType>"
    And User clicks Company under Activity Stream
    When Verify users see the following modules in the Company page shown as design

      | Official Information |
      | Our Life             |
      | About Company        |
      | Photo Gallery        |
      | Video                |
      | Career               |
      | Business News (RSS)  |

    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |



