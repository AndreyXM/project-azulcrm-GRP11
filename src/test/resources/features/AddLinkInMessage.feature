@link
Feature: Add link in message
  As a user, I want to add a link to a message
  So that recipients can click and be redirected to the provided URL


  Scenario Outline: User adds a link to a message
    Given the user logged in as "<userType>"
    When the user is on the activity stream page
    And the user clicks on the Send Message field
    And selects the Link option
    And fills in the Link text field with "<linkText>"
    And fills in the Link URL field with "<linkURL>"
    And clicks the Save button
    And the user clicks send button
    When the user clicks on the link in the message
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