Feature: Company Page Functionality


  Scenario Outline: User should be able to access the company page
    Given the user is on the login page
    Then user enters username "<username>" and password "<password>"
    Examples:
      | username             | password |
      | hr1@cydeo.com        | UserUser |
      | helpdesk1@cydeo.com  | UserUser |
      | marketing1@cydeo.com | UserUser |
    Then User clicks Company under Activity Stream
    Then Verify users see the following modules in the Company page shown as design

      | Official Information |
      | Our Life             |
      | About Company        |
      | Photo Gallery        |
      | Video                |
      | Career               |
      | Business News (RSS)  |



