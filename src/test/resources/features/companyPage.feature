Feature: Company Page Functionality


  @companyRun
  Scenario: User should be able to access the company page
    Given User is logged in as a "hr1"
    Then User clicks Company under Activity Stream
    Then Verify users see the following modules in the Company page shown as design
      | Official Information |
      | Our Life             |
      | About Company        |
      | Photo Gallery        |
      | Video                |
      | Career               |
      | Business News (RSS)  |
