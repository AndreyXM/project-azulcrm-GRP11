package com.azulcrm.step_definitions;

import com.azulcrm.pages.SendMessagePage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.ConfigurationReader;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class SendMessageStepDefs {

    SendMessagePage sendMessagePage = new SendMessagePage();

    @When("the user enters the {string}")
    public void the_user_enters_the(String messageContent) {
        WebElement iframe = Driver.getDriver ().findElement (By.className ("bx-editor-iframe"));
        //Switch to the frame
        Driver.getDriver ().switchTo ().frame (iframe);

        sendMessagePage.messageTitleBox.sendKeys (messageContent);
        Driver.getDriver ().switchTo ().defaultContent ();
        BrowserUtils.sleep (5);

    }

    @When("the user enters a {string}")
    public void the_user_enters_a(String recipient) {
    sendMessagePage.recipientBoxDelete.click();
    sendMessagePage.addRecipientLink.click();
    sendMessagePage.recipientBox.sendKeys (recipient + Keys.ENTER);
    BrowserUtils.sleep(3);
    }


    @And("the user clicks on cancel button")
    public void theUserClicksOnCancelButton() {
        sendMessagePage.cancelButton.click();
        BrowserUtils.sleep(3);
    }

    @And("the user enters {string}")
    public void theUserEnters(String messageContent) {
        WebElement iframe = Driver.getDriver ().findElement (By.className ("bx-editor-iframe"));
        //Switch to the frame
        Driver.getDriver ().switchTo ().frame (iframe);

        sendMessagePage.messageTitleBox.sendKeys (messageContent);
        Driver.getDriver ().switchTo ().defaultContent ();
        BrowserUtils.sleep (5);
    }

    @And("the user see {string} as default")
    public void theUserSeeAsDefault(String defaultRecipient) {
        String expectedRecipient = "All employees" ;
        String actualRecipient = sendMessagePage.defaultAddEmployee.getText ();
        System.out.println ("expectedRecipient = " + expectedRecipient);
        System.out.println ("actualRecipient = " + actualRecipient);
        BrowserUtils.waitForPageToLoad (5);
        Assert.assertEquals (expectedRecipient, actualRecipient);

    }


    @And("the user cancel the recipient")
    public void theUserCancelTheRecipient() {
        sendMessagePage.recipientBoxDelete.click();
        BrowserUtils.sleep(2);
    }




    @Then("the user sees {string}, {string}, {string}  on the page")
    public void theUserSeesOnThePage(String userType, String messagecontent, String recipient) {
     String expectedUserName = "";

        if (userType.equalsIgnoreCase("hr")) {
            expectedUserName = ConfigurationReader.getProperty("hr_username");
        } else if (userType.equalsIgnoreCase("helpdesk")) {
            expectedUserName = ConfigurationReader.getProperty("helpdesk_username");
        } else if (userType.equalsIgnoreCase("marketing")) {
            expectedUserName = ConfigurationReader.getProperty("marketing_username");
        }


        BrowserUtils.sleep (3);


        // Validate sender name
        String actualSender = sendMessagePage.sender.getText();
        System.out.println("Expected Sender: " + userType + ", Actual Sender: " + actualSender);
        Assert.assertEquals(expectedUserName, actualSender);

        // Validate message content
        String actualMessageContent = sendMessagePage.textDisplayed.getText();
        System.out.println("Expected Message Content: " + messagecontent + ", Actual Message Content: " + actualMessageContent);
        Assert.assertEquals(messagecontent, actualMessageContent);

        // Validate recipient email
        String actualRecipient = sendMessagePage.receiver.getText();
        System.out.println("Expected Recipient: " + recipient + ", Actual Recipient: " + actualRecipient);
        Assert.assertEquals(recipient, actualRecipient);


    }


}

