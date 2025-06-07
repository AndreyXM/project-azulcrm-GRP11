@allPolls
Feature: Poll Creation
  @Poll
  Scenario Outline: Poll creation as user

    Given the user is on the login page
    When the user logged in as "<userType>"
    When  the user clicks on poll button
    And   the user creates a poll by adding "<MessageTitle>", "<Question>" and "<Answer1>" and "<Answer2>"
    And   the user selects Allow multiple choice checkbox
    Then  the user clicks send button

    Examples:

      | userType  | MessageTitle | Question                 | Answer1                 | Answer2                 |
      | hr        | Title check1 | Test Hr Question?        | Test Hr Answer 1        | Test Hr Answer 2        |
      | helpdesk  | Title check2 | Test HelpDesk Question?  | Test HelpDesk Answer 1  | Test HelpDeskAnswer 2   |
      | marketing | Title check3 | Test Marketing Question? | Test Marketing Answer 1 | Test Marketing Answer 2 |

  @MessageTitleVerification
  Scenario Outline: Message Title verification

    Given the user is on the login page
    When the user logged in as "<userType>"
    When  the user clicks on poll button
    And   the user creates a poll by adding "<Question>" and "<Answer1>" and "<Answer2>"
    And   the user selects Allow multiple choice checkbox
    And   the user clicks send button
    Then  the user sees "The message title is not specified" message on dashboard header

    Examples:

      | userType  | Question                 | Answer1                 | Answer2                 |
      | hr        | Test Hr Question?        | Test Hr Answer 1        | Test Hr Answer 2        |
      | helpdesk  | Test HelpDesk Question?  | Test HelpDesk Answer 1  | Test HelpDeskAnswer 2   |
      | marketing | Test Marketing Question? | Test Marketing Answer 1 | Test Marketing Answer 2 |

  @Recipient
  Scenario Outline: Recipient verification

    Given the user is on the login page
    When the user logged in as "<userType>"
    When  the user clicks on poll button
    And   the user types "<MessageTitle>" on Message Title section
    And   the user enters valid "<EmployeeName>" in the recipient box
    And   the user enters "<Question>" and "<Answer1>" and "<Answer2>"
    And   the user selects Allow multiple choice checkbox
    Then  the user clicks send button

    Examples:

      | userType  | MessageTitle | EmployeeName | Question                 | Answer1                 | Answer2                 |
      | hr        | Title check1 | Nadir        | Test Hr Question?        | Test Hr Answer 1        | Test Hr Answer 2        |
      | helpdesk  | Title check2 | Asiya        | Test HelpDesk Question?  | Test HelpDesk Answer 1  | Test HelpDeskAnswer 2   |
      | marketing | Title check3 | Employee     | Test Marketing Question? | Test Marketing Answer 1 | Test Marketing Answer 2 |