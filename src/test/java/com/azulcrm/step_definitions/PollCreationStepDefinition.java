package com.azulcrm.step_definitions;


import com.azulcrm.pages.PollCreationPage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class PollCreationStepDefinition {

    PollCreationPage pollCreationPage = new PollCreationPage ();

    @Then("the user clicks on poll button")
    public void the_user_clicks_on_poll_button() {
        pollCreationPage.pollButton.click ();
        BrowserUtils.sleep (1);
    }

    @Then("the user creates a poll by adding {string}, {string} and {string} and {string}")
    public void theUserCreatesAPollByAddingAndAnd(String messageTitleTest1, String questionTest1, String answer1Test1, String answer2Test1) {

        WebElement iframe = Driver.getDriver ().findElement (By.className ("bx-editor-iframe"));
        //Switch to the frame
        Driver.getDriver ().switchTo ().frame (iframe);

        pollCreationPage.messageTitleBox.sendKeys (messageTitleTest1);
        Driver.getDriver ().switchTo ().defaultContent ();
        //Driver.getDriver ().switchTo ().frame (0);

        pollCreationPage.questionBox.sendKeys (questionTest1);
        pollCreationPage.answerBox1.sendKeys (answer1Test1);
        pollCreationPage.answerBox2.sendKeys (answer2Test1);
        BrowserUtils.sleep (1);
    }

    @And("the user selects Allow multiple choice checkbox")
    public void theUserSelectsAllowMultipleChoiceCheckbox() {
        pollCreationPage.multipleChoiceBox.click ();
        BrowserUtils.sleep (1);
        boolean isChecked = pollCreationPage.multipleChoiceBox.isSelected ();
        Assert.assertTrue ("CheckBox is not checked", isChecked);

        //System.out.println ("pollCreationPage.multipleChoiceBox.isSelected () = " + pollCreationPage.multipleChoiceBox.isSelected ());

    }

    @Then("the user clicks send button")
    public void theUserClicksSendButton() {
        pollCreationPage.pollSendButton.click ();
        BrowserUtils.sleep (3);
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
        BrowserUtils.waitFor (2);
        pollCreationPage.addRecipientLink.click ();
        BrowserUtils.waitFor (1);
        pollCreationPage.recipientBox.sendKeys (employee + Keys.ENTER);
        BrowserUtils.waitFor (2);
    }

    @And("the user enters {string} and {string} and {string}")
    public void theUserEntersAndAnd(String question1Test3, String answer1Test3, String answer2Test3) {
        pollCreationPage.questionBox.sendKeys (question1Test3);
        pollCreationPage.answerBox1.sendKeys (answer1Test3);
        pollCreationPage.answerBox2.sendKeys (answer2Test3);
    }
}






