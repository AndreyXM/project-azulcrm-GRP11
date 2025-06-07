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

    @Then("the user clicks on poll button")
    public void the_user_clicks_on_poll_button() {
        pollCreationPage.pollButton.click ();
        BrowserUtils.sleep (1);
    }

    @Then("the user creates a poll by adding {string}, {string} and {string} and {string}")
    public void theUserCreatesAPollByAddingAndAnd(String messageTitleTest1, String questionTest1, String answer1Test1, String answer2Test1) {
        createPoll (messageTitleTest1, questionTest1, answer1Test1, answer2Test1);
    }

    @And("the user selects Allow multiple choice checkbox")
    public void theUserSelectsAllowMultipleChoiceCheckbox() {
        pollCreationPage.multipleChoiceBox.click ();
        BrowserUtils.waitFor (2);
        boolean isChecked = pollCreationPage.multipleChoiceBox.isSelected ();
        Assert.assertTrue ("CheckBox is not checked", isChecked);

        //System.out.println ("pollCreationPage.multipleChoiceBox.isSelected () = " + pollCreationPage.multipleChoiceBox.isSelected ());

    }

    @Then("the user clicks send button")
    public void theUserClicksSendButton() {
        pollCreationPage.pollSendButton.click ();
        BrowserUtils.waitFor (1);
    }

    @And("the user creates a poll by adding {string} and {string} and {string}")
    public void theUserCreatesAPollByAddingAndAnd(String question1Test2, String answer1Test2, String answer2Test2) {
        pollCreationPage.questionBox.sendKeys (question1Test2);
        pollCreationPage.answerBox1.sendKeys (answer1Test2);
        pollCreationPage.answerBox2.sendKeys (answer2Test2);
    }

    @Then("the user sees {string} message on dashboard header")
    public void theUserSeesMessageOnDashboardHeader(String expectedHeader) {
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
        BrowserUtils.waitFor (2);
    }

    @And("the user enters valid {string} in the recipient box")
    public void theUserEntersValidInTheRecipientBox(String employee) {
        pollCreationPage.recipientBoxDelete.click ();
        pollCreationPage.addRecipientLink.click ();
        pollCreationPage.recipientBox.sendKeys (employee + Keys.ENTER);

    }

    @And("the user enters {string} and {string} and {string}")
    public void theUserEntersAndAnd(String question1Test3, String answer1Test3, String answer2Test3) {
        pollCreationPage.questionBox.sendKeys (question1Test3);
        pollCreationPage.answerBox1.sendKeys (answer1Test3);
        pollCreationPage.answerBox2.sendKeys (answer2Test3);
    }


    public void createPoll(String messageTitle, String question, String answer1, String answer2){
        DashboardPage dashboardPage = new DashboardPage ();
        Actions actions = new Actions (Driver.getDriver ());

        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss"));
        String msgText = "New message (" + timeStamp + ")";

        WebElement iframe = dashboardPage.iframeEditMsg;
        //Switch to the frame
        Driver.getDriver ().switchTo ().frame (iframe);
        actions.sendKeys ("").keyDown (Keys.SHIFT).sendKeys (Keys.ENTER).keyUp (Keys.SHIFT).sendKeys (msgText).perform ();

        Driver.getDriver ().switchTo ().defaultContent ();
        //Driver.getDriver ().switchTo ().frame (0);

        pollCreationPage.questionBox.sendKeys (question);
        pollCreationPage.answerBox1.sendKeys (answer1);
        pollCreationPage.answerBox2.sendKeys (answer2);
        BrowserUtils.sleep (1);
    }
}






