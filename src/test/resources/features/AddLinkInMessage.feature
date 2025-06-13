@addLink
Feature: Add link in message
  As a user, I want to add a link to a message
  So that recipients can click and be redirected to the provided URL

  Background:
    Given the user is on the login page

  Scenario Outline: User "<userType>" adds "<linkText>" link to a message
    When the user logged in as "<userType>"
    And the user is on the activity stream page
    And the user clicks on main menu "Message"
    And selects the Link option
    And fills in the Link text field with "<linkText>"
    And fills in the Link URL field with "<linkURL>"
    And clicks the Save button
    And the user clicks send button
    And the user clicks on the link in the message
    Then the user should be redirected to "<linkURL>"

    Examples:
      | userType  | linkText      | linkURL                  |
      | hr        | Google Site   | https://www.google.com   |
      | helpdesk  | GitHub Page   | https://github.com       |
      | marketing | Selenium Page | https://www.selenium.dev |


  Scenario Outline: User cannot send the same message with the same link twice
    When the user logged in as "<userType>"
    And the user is on the activity stream page
    And the user clicks on main menu "Message"
    And selects the Link option
    And fills in the Link text field with exact text "<linkText>"
    And fills in the Link URL field with "<linkURL>"
    And clicks the Save button
    And the user clicks send button

    And the user clicks on main menu "Message"
    And selects the Link option
    And fills in the Link text field with exact text "<linkText>"
    And fills in the Link URL field with "<linkURL>"
    And clicks the Save button
    And the user clicks send button

    Then the system should display an error message about duplicate content

    Examples:
      | userType | linkText            | linkURL             |
      | hr       | Duplicate Link Test | https://example.com |

  Scenario Outline: User sends a message with a link but no link text
    When the user logged in as "<userType>"
    And the user is on the activity stream page
    And the user clicks on main menu "Message"
    And selects the Link option
    And fills in the Link text field with "<linkText>"
    And fills in the Link URL field with "<linkURL>"
    And clicks the Save button
    And the user clicks send button
    Then the message should display the "<linkURL>" as a clickable link

    Examples:
      | userType | linkText | linkURL             |
      | hr       |          | https://example.com |