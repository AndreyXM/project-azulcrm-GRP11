@addLink
Feature: Add link in message
  As a user, I want to add a link to a message
  So that recipients can click and be redirected to the provided URL

  Scenario Outline: User "<userType>" adds "<linkText>" link to a message
    Given the user is on the login page
    When the user logged in as "<userType>"
    And the user is on the activity stream page
    And the user clicks on the Send Message field
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


  Scenario: User cannot send the same message with the same link twice
    Given the user logged in as "hr"
    When the user is on the activity stream page
    And the user clicks on the Send Message field
    And selects the Link option
    And fills in the Link text field with exact text "Duplicate Link Test"
    And fills in the Link URL field with "https://example.com"
    And clicks the Save button
    And the user clicks send button

    And the user clicks on the Send Message field
    And selects the Link option
    And fills in the Link text field with exact text "Duplicate Link Test"
    And fills in the Link URL field with "https://example.com"
    And clicks the Save button
    And the user clicks send button

    Then the system should display an error message about duplicate content


  Scenario: User sends a message with a link but no link text
    Given the user logged in as "hr"
    When the user is on the activity stream page
    And the user clicks on the Send Message field
    And selects the Link option
    And leaves the Link text field empty
    And fills in the Link URL field with "https://example.com"
    And clicks the Save button
    And the user clicks send button
    Then the message should display the raw URL as a clickable link