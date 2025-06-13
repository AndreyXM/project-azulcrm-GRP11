@allMessage_Test
Feature: Message Creation

  Background:
    Given the user is on the login page

  @Message_Test
  Scenario Outline: Message creation as user

    When the user logged in as "<userType>"
    And the user clicks on main menu "Message"
    And the user enters the "<MessageContent>"
    And the user enters a "<Recipient>"
    And the user clicks send button
    Then the user sees "<userType>", "<MessageContent>", "<Recipient>"  on the page

    Examples:
      | userType  | MessageContent         | Recipient            |
      | hr        | Test message hr        | hr5@cydeo.com        |
      | helpdesk  | Test message helpdesk  | helpdesk5@cydeo.com  |
      | marketing | Test message marketing | marketing5@cydeo.com |

  @MessageTitleVerification_Test
  Scenario Outline: Message title verification

    When the user logged in as "<userType>"
    And the user clicks on main menu "Message"
    And the user enters a "<Recipient>"
    And the user clicks send button
    Then  the user sees "The message title is not specified" message title error message on dashboard header

    Examples:
      | userType  | Recipient            |
      | hr        | hr5@cydeo.com        |
      | helpdesk  | helpdesk5@cydeo.com  |
      | marketing | marketing5@cydeo.com |

  @RecipientVerification_Test
  Scenario Outline: Recipient verification

    Given the user is on the login page
    When the user logged in as "<userType>"
    And the user clicks on main menu "Message"
    And the user cancel the recipient
    And the user clicks send button
    Then  the user sees "Please specify at least one person." message title error message on dashboard header

    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |

  @DefaultRecipientAsUser_Test
  Scenario Outline: Default recipient as user

    When the user logged in as "<userType>"
    And the user clicks on main menu "Message"
    And the user enters the "<MessageContent>"
    And the user see "<Recipient>" as default
    And the user clicks send button

    Examples:
      | userType  | MessageContent         | Recipient     |
      | hr        | Test message hr        | All employees |
      | helpdesk  | Test message helpdesk  | All employees |
      | marketing | Test message marketing | All employees |

  @MessageCancelAsUser
  Scenario Outline: Message cancel as user

    When the user logged in as "<userType>"
    And the user clicks on main menu "Message"
    And the user enters the "<MessageContent>"
    And the user enters a "<Recipient>"
    And the user clicks on cancel button

    Examples:
      | userType  | MessageContent         | Recipient            |
      | hr        | Test message hr        | hr5@cydeo.com        |
      | helpdesk  | Test message helpdesk  | helpdesk5@cydeo.com  |
      | marketing | Test message marketing | marketing5@cydeo.com |