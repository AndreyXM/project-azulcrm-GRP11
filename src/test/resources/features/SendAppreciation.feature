Feature: send appreciation

  Background:
    Given the user is on the login page

@sendApp
  Scenario Outline:the user "<userType>" should be able to send appreciation
    When the user logged in as "<userType>"
    And the user Send to "<appreciation>"
    And the user Click On "<All employees>"
    Then the user cancel sending appreciation
    Examples:
      | userType  | appreciation       | All employees |
      | hr        |test valid          |Pass           |
      | helpdesk  |test invalid        |Fail           |
      | marketing |test valid          |Pass           |






