package com.azulcrm.step_definitions;


import com.azulcrm.pages.PollCreationPage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PollCreationStepDefinition {

    PollCreationPage pollCreationPage = new PollCreationPage ();

    @Then("the user clicks on poll button")
    public void the_user_clicks_on_poll_button() {
        pollCreationPage.pollButton.click ();
        BrowserUtils.sleep (1);
    }

    @Then("the user creates a poll by adding {string}, {string} and {string} and {string}")
    public void theUserCreatesAPollByAddingAndAnd(String messageTitle, String question, String answer1, String answer2) {

        WebElement iframe = Driver.getDriver ().findElement (By.className ("bx-editor-iframe"));
        //Switch to the frame
        Driver.getDriver ().switchTo ().frame (iframe);

        pollCreationPage.messageTitleBox.sendKeys (messageTitle);
        Driver.getDriver ().switchTo ().defaultContent ();
        //Driver.getDriver ().switchTo ().frame (0);

        pollCreationPage.questionBox.sendKeys (question);
        pollCreationPage.answerBox1.sendKeys (answer1);
        pollCreationPage.answerBox2.sendKeys (answer2);
        BrowserUtils.sleep (1);
    }


    @And("the user should be able to select Allow multiple choice checkbox")
    public void theUserShouldBeAbleToSelectAllowMultipleChoiceCheckbox() {
        pollCreationPage.multipleChoiceBox.click ();
        BrowserUtils.sleep (1);

    }

    @Then("the user clicks send button")
    public void theUserClicksSendButton() {
        pollCreationPage.pollSendButton.click ();
        BrowserUtils.sleep (3);
    }

    @And("the user creates a poll by adding {string} and {string} and {string}")
    public void theUserCreatesAPollByAddingAndAnd(String question, String answer1, String answer2) {
        pollCreationPage.questionBox.sendKeys (question);
        pollCreationPage.answerBox1.sendKeys (answer1);
        pollCreationPage.answerBox2.sendKeys (answer2);
    }

    @Then("the user sees {string} message on dashboard header")
    public void theUserSeesMessageOnDashboardHeader(String expectedHeader) {
        String actualHeader = pollCreationPage.messageTitleHeader.getText ();
        Assert.assertEquals (expectedHeader,actualHeader);
    }
}






