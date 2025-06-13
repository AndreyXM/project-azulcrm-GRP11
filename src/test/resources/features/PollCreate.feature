@allPollsTest
Feature: Poll Creation functionality
    User Story : As a user, I should be able to create a poll by clicking on Poll tab under Active Stream.

  Background:
    Given the user is on the login page

  @PollTest
  Scenario Outline: Poll creation as user

   #Given the user is on the login page
    When  the user logged in as "<userType>"
    And   the user clicks on main menu "Poll"
    And   the user creates a poll by adding "<MessageTitle>", "<Question>" and "<Answer1>" and "<Answer2>"
    And   the user selects Allow multiple choice checkbox
    And   the user clicks send button
    Then  the user verify that poll is created by matching the "<MessageTitle>" and the time on the message title

    Examples:

      | userType  | MessageTitle | Question                 | Answer1                 | Answer2                 |
      | hr        | Title check1 | Test Hr Question?        | Test Hr Answer 1        | Test Hr Answer 2        |
      | helpdesk  | Title check2 | Test HelpDesk Question?  | Test HelpDesk Answer 1  | Test HelpDeskAnswer 2   |
      | marketing | Title check3 | Test Marketing Question? | Test Marketing Answer 1 | Test Marketing Answer 2 |

  @MessageTitleVerificationTest
  Scenario Outline: Poll creation Message Title verification

   #Given the user is on the login page
    When  the user logged in as "<userType>"
    And   the user clicks on main menu "Poll"
    And   the user creates a poll by adding empty "<MessageTitle>" and "<Question>" and "<Answer1>" and "<Answer2>"
    And   the user selects Allow multiple choice checkbox
    And   the user clicks send button
    Then  the user sees "The message title is not specified" message title error message on dashboard header

    Examples:

      | userType  | MessageTitle | Question                 | Answer1                 | Answer2                 |
      | hr        |              | Test Hr Question?        | Test Hr Answer 1        | Test Hr Answer 2        |
      | helpdesk  |              | Test HelpDesk Question?  | Test HelpDesk Answer 1  | Test HelpDeskAnswer 2   |
      | marketing |              | Test Marketing Question? | Test Marketing Answer 1 | Test Marketing Answer 2 |

  @RecipientTest
  Scenario Outline: Poll creation Recipient verification

   #Given the user is on the login page
    When  the user logged in as "<userType>"
    And   the user clicks on main menu "Poll"
    And   the user enters valid "<Employee>" in the recipient box
    And   the user creates a poll by adding "<MessageTitle>", "<Question>" and "<Answer1>" and "<Answer2>"
    And   the user selects Allow multiple choice checkbox
    And   the user clicks send button
    Then  the user verify that poll is created by matching the "<MessageTitle>" and the time on the message title

    Examples:

      | userType  | MessageTitle | Employee | Question                 | Answer1                 | Answer2                 |
      | hr        | Title check1 | Nadir    | Test Hr Question?        | Test Hr Answer 1        | Test Hr Answer 2        |
      | helpdesk  | Title check2 | Asiya    | Test HelpDesk Question?  | Test HelpDesk Answer 1  | Test HelpDeskAnswer 2   |
      | marketing | Title check3 | Employee | Test Marketing Question? | Test Marketing Answer 1 | Test Marketing Answer 2 |

  @QuestionTextTest
  Scenario Outline: Poll creation Question text error message verification

   #Given the user is on the login page
    When  the user logged in as "<userType>"
    And   the user clicks on main menu "Poll"
    And   the user creates a poll by adding "<MessageTitle>", empty "<Question>" box, valid "<Answer1>" and valid "<Answer2>"
    And   the user selects Allow multiple choice checkbox
    And   the user clicks send button
    Then  the user sees "The question text is not specified." question error message on dashboard header

    Examples:

      | userType  | MessageTitle | Question | Answer1                 | Answer2                 |
      | hr        | Title check1 |          | Test Hr Answer 1        | Test Hr Answer 2        |
      | helpdesk  | Title check2 |          | Test HelpDesk Answer 1  | Test HelpDeskAnswer 2   |
      | marketing | Title check3 |          | Test Marketing Answer 1 | Test Marketing Answer 2 |

  @AnswerTextTest
  Scenario Outline: Poll creation Answer text error verification

   #Given the user is on the login page
    When  the user logged in as "<userType>"
    And   the user clicks on main menu "Poll"
    And   the user creates a poll by adding "<MessageTitle>", valid "<Question>" box, empty "<Answer1>" and empty "<Answer2>"
    And   the user selects Allow multiple choice checkbox
    And   the user clicks send button
    Then  the user sees The question "<Question>" has no answers. answer error message on dashboard header

    Examples:

      | userType  | MessageTitle | Question                 | Answer1 | Answer2 |
      | hr        | Title check1 | Test Hr Question?        |         |         |
      | helpdesk  | Title check2 | Test HelpDesk Question?  |         |         |
      | marketing | Title check3 | Test Marketing Question? |         |         |