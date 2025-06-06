package com.azulcrm.step_definitions;

import com.azulcrm.pages.ActivityStreamPage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class AddLinkInMessageStepDefs {

    ActivityStreamPage activityStreamPage = new ActivityStreamPage();

    @Then("the user is on the activity stream page")
    public void the_user_is_on_the_activity_stream_page() {
        BrowserUtils.verifyURLContains("stream");
    }

    @When("the user clicks on the Send Message field")
    public void the_user_clicks_on_the_field() {
        activityStreamPage.sendMessageField.click();
    }

    @When("selects the Link option")
    public void selects_the_link_option() {
        activityStreamPage.addLinkBtn.click();
    }

    @When("fills in the Link text field with {string}")
    public void fills_in_the_text_field_with(String linkText) {
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String finalText = timeStamp + " - " + linkText;
        activityStreamPage.linkTextInput.sendKeys(finalText);
    }

    @When("fills in the Link URL field with {string}")
    public void fills_in_the_url_field_with(String linkURL) {
        activityStreamPage.linkURLInput.sendKeys(linkURL);
    }

    @When("clicks the Save button")
    public void clicks_the_save_button() {
        activityStreamPage.saveBtn.click();
    }

    @When("the user clicks on the link in the message")
    public void the_user_clicks_on_the_link_in_the_message() {
        activityStreamPage.messageLink.click();
    }


    @Then("the user should be redirected to {string}")
    public void the_user_should_be_redirected_to(String linkURL) {
        String originalWindow = Driver.getDriver().getWindowHandle();
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();
        String newWindowHandle = null;
        for (String eachWindowHandle : allWindowHandles) {
            if (!eachWindowHandle.equals(originalWindow)) {
                newWindowHandle = eachWindowHandle;
                break;
            }
        }
        if (newWindowHandle == null) {
            throw new RuntimeException("New window/tab was not opened.");
        }
        Driver.getDriver().switchTo().window(newWindowHandle);
        BrowserUtils.waitForPageToLoad(10);

        String actualURL = Driver.getDriver().getCurrentUrl();
        System.out.println("Redirected to: " + actualURL);

        assert actualURL != null;
        Assert.assertTrue("The redirection URL is incorrect!",
                actualURL.contains(linkURL));

    }
    //Step Definition for the Error Message:
    @Then("the system should display an error message about duplicate content")
    public void the_system_should_display_error_message() {
        BrowserUtils.waitForVisibility(activityStreamPage.duplicateMessageError, 5);
        Assert.assertTrue(activityStreamPage.duplicateMessageError.isDisplayed());
    }

    @When("fills in the Link text field with exact text {string}")
    public void fills_in_the_link_text_field_with_exact_text(String linkText) {
        activityStreamPage.linkTextInput.sendKeys(linkText);
    }
}
