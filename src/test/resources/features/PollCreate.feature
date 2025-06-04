Feature: Poll Creation


  @Poll
  Scenario Outline: Poll creation as user
    # Given the user logged in as hr
    Given the user logged in as "<userType>"
    When  the user clicks on poll button
    And   the user creates a poll by adding "<MessageTitle>", "<Question>" and "<Answer1>" and "<Answer2>"
    And   the user should be able to select Allow multiple choice checkbox
    Then  the user clicks send button

    Examples:

      | userType  | MessageTitle | Question     | Answer1 | Answer2 |
      | hr        | Title check1 | What is 2+1? | 1 (One) | 2 (Two) |
      | helpdesk  | Title check2 | What is 3+1? | 1 (One) | 2 (Two) |
      | marketing | Title check3 | What is 4+1? | 1 (One) | 2 (Two) |

