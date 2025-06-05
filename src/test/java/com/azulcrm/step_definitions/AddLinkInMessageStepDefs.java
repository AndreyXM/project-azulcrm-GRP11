package com.azulcrm.step_definitions;

import com.azulcrm.pages.ActivityStreamPage;
import com.azulcrm.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
        activityStreamPage.linkTextInput.sendKeys(linkText);
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
    public void the_user_should_be_redirected_to(String string) {

    }
}
