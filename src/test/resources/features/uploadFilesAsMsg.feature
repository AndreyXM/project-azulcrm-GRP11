@uploadFilesAsMsg
Feature: functionality of Uploading Files in Message


  Scenario Outline: user "<userType>" should be able to upload "<File>" as messages
    Given the user logged in as "<userType>"
    When the user clicks on Message
    And the user clicks on Upload Files
    And the user clicks on Upload Files and Images to select file "<File>"
    And the user click on Insert In Text
    Then the user see file "<File>" in Message window

    Examples:
      | userType  | File              |
      | hr        | TestDocsFile.docx |
      | hr        | TestPDFFile.pdf   |
      | hr        | TestTextFile.txt  |
      | hr        | TestJPEGFile.jpeg |
      | hr        | TestPNGFile.png   |
      | helpdesk  | TestDocsFile.docx |
      | helpdesk  | TestPDFFile.pdf   |
      | helpdesk  | TestTextFile.txt  |
      | helpdesk  | TestJPEGFile.jpeg |
      | helpdesk  | TestPNGFile.png   |
      | marketing | TestDocsFile.docx |
      | marketing | TestPDFFile.pdf   |
      | marketing | TestTextFile.txt  |
      | marketing | TestJPEGFile.jpeg |
      | marketing | TestPNGFile.png   |

  Scenario Outline: user "<userType>" should be able to upload "<File>" as messages and remove it
    Given the user logged in as "<userType>"
    When the user clicks on Message
    And the user clicks on Upload Files
    And the user clicks on Upload Files and Images to select file "<File>"
    And the user click on Insert In Text
    And the user click on Remove Files and Images
    Then the user not see selected "<File>" in Message window

    Examples:
      | userType  | File              |
      | hr        | TestDocsFile.docx |
      | helpdesk  | TestTextFile.txt  |
      | marketing | TestJPEGFile.jpeg |