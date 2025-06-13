package com.azulcrm.step_definitions;

import com.azulcrm.pages.DashboardPage;
import com.azulcrm.pages.PollCreationPage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PollCreationStepDefinition {

    PollCreationPage pollCreationPage = new PollCreationPage ();

    Actions actions = new Actions (Driver.getDriver ());
    String timeStamp = LocalDateTime.now ().format (DateTimeFormatter.ofPattern ("MM/dd/yyyy HH:mm:ss"));
    String msgText = "New message (" + timeStamp + ")";

    @Then("the user creates a poll by adding {string}, {string} and {string} and {string}")
    public void theUserCreatesAPollByAddingAndAnd(String messageTitleTest1, String questionTest1, String answer1Test1, String answer2Test1) {
        createPollMessage (messageTitleTest1, questionTest1, answer1Test1, answer2Test1);
    }

    @And("the user selects Allow multiple choice checkbox")
    public void theUserSelectsAllowMultipleChoiceCheckbox() {
        pollCreationPage.multipleChoiceBox.click ();
        boolean isChecked = pollCreationPage.multipleChoiceBox.isSelected ();
        Assert.assertTrue ("CheckBox is not checked", isChecked);
        //System.out.println ("pollCreationPage.multipleChoiceBox.isSelected () = " + pollCreationPage.multipleChoiceBox.isSelected ());
    }

    @Then("the user clicks send button")
    public void theUserClicksSendButton() {
        pollCreationPage.sendButton.click ();
        //BrowserUtils.waitFor(1);
    }

    @And("the user creates a poll by adding empty {string} and {string} and {string} and {string}")
    public void theUserCreatesAPollByAddingEmptyAndAndAnd(String emptyMessageTitle, String question, String answer1, String answer2) {
        createPollMessage (emptyMessageTitle, question, answer1, answer2);
    }

    @Then("the user sees {string} message title error message on dashboard header")
    public void theUserSeesMessageTitleErrorMessageOnDashboardHeader(String expectedHeader) {
        String actualHeader = pollCreationPage.messageTitleHeader.getText ();
        Assert.assertEquals (expectedHeader, actualHeader);
    }

    @And("the user types {string} on Message Title section")
    public void theUserTypesOnMessageTitleSection(String messageTitle) {
        WebElement iframe = Driver.getDriver ().findElement (By.className ("bx-editor-iframe"));
        //Switch to the frame
        Driver.getDriver ().switchTo ().frame (iframe);

        pollCreationPage.messageTitleBox.sendKeys (messageTitle);
        Driver.getDriver ().switchTo ().defaultContent ();
        BrowserUtils.waitFor (1);
    }

    @And("the user enters valid {string} in the recipient box")
    public void theUserEntersValidInTheRecipientBox(String employee) {
        pollCreationPage.recipientBoxDelete.click ();
        pollCreationPage.addRecipientLink.click ();
        pollCreationPage.recipientBox.sendKeys (employee + Keys.ENTER);
    }

    @And("the user creates a poll by adding {string}, empty {string} box, valid {string} and valid {string}")
    public void theUserCreatesAPollByAddingEmptyBoxValidAndValid(String messageTitle, String question, String answer1, String answer2) {
        createPollMessage (messageTitle, question, answer1, answer2);
    }

    @Then("the user sees {string} question error message on dashboard header")
    public void theUserSeesQuestionErrorMessageOnDashboardHeader(String expectedHeader) {
        String actualHeader = pollCreationPage.questionTitleHeader.getText ();
        Assert.assertEquals (expectedHeader, actualHeader);
    }

    @And("the user creates a poll by adding {string}, valid {string} box, empty {string} and empty {string}")
    public void theUserCreatesAPollByAddingValidBoxEmptyAndEmpty(String messageTitle, String question, String answer1, String answer2) {
        createPollMessage (messageTitle, question, answer1, answer2);
    }

    @Then("the user sees The question {string} has no answers. answer error message on dashboard header")
    public void theUserSeesTheQuestionHasNoAnswersAnswerErrorMessageOnDashboardHeader(String str) {
        String expectedHeader = "The question " + "\"" + str + "\"" + " has no answers.";
        String actualHeader = pollCreationPage.questionTitleHeader.getText ();
        System.out.println ("expectedHeader = " + expectedHeader);
        System.out.println ("actualHeader = " + actualHeader);
        BrowserUtils.waitForPageToLoad (5);
        Assert.assertEquals (expectedHeader, actualHeader);
    }

    public void createPollMessage(String messageTitle, String question, String answer1, String answer2) {
        DashboardPage dashboardPage = new DashboardPage ();
        WebElement iframe = dashboardPage.iframeEditMsg;
        //Switch to the frame
        Driver.getDriver ().switchTo ().frame (iframe);
        if (!messageTitle.isEmpty ()) {

//            Actions actions = new Actions (Driver.getDriver ());
//            String timeStamp = LocalDateTime.now ().format (DateTimeFormatter.ofPattern ("MM/dd/yyyy HH:mm:ss"));
//            String msgText = "New message (" + timeStamp + ")";

            actions.click (pollCreationPage.messageTitleBox)
                    .sendKeys (messageTitle)
                    .keyDown (Keys.SHIFT)
                    .sendKeys (Keys.ENTER)
                    .keyUp (Keys.SHIFT)
                    .sendKeys (msgText)
                    .perform ();
        }
        Driver.getDriver ().switchTo ().defaultContent ();
        //Driver.getDriver ().switchTo ().frame (0);
        BrowserUtils.waitForVisibility (pollCreationPage.questionBox, 3);
        pollCreationPage.questionBox.sendKeys (question);
        pollCreationPage.answerBox1.sendKeys (answer1);
        pollCreationPage.answerBox2.sendKeys (answer2);
    }

    @Then("the user verify that poll is created by matching the {string} and the time on the message title")
    public void theUserVerifyThatPollIsCreatedByMatchingTheAndTheTimeOnTheMessageTitle(String messageTitle) {
        BrowserUtils.sleep (3);
        String expectedMessageTime = messageTitle + "\n" + "New message (" + timeStamp + ")";
        String actualMessageTimeText = pollCreationPage.creationPollVerification.getText ();

        System.out.println ("actualMessageTimeText = " + actualMessageTimeText);
        Assert.assertEquals (expectedMessageTime, actualMessageTimeText);

    }
}
