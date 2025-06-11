@companyPage
Feature: Company Page Functionality
  As a user, I should be able to access to the Company page .

  Scenario Outline: User "<userType>" should be able to access the company page
    Given the user is on the login page
    When the user logged in as "<userType>"
    And User clicks Company under Activity Stream
    Then Verify users see the following modules in the Company page shown as design

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



