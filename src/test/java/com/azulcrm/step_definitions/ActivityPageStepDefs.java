package com.azulcrm.step_definitions;

import com.azulcrm.pages.ActivityStreamPage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.List;

public class ActivityPageStepDefs {
    ActivityStreamPage  activityStreamPage = new ActivityStreamPage();

    @When("the user navigates to the Activity Stream page")
    public void the_user_navigates_to_the_activity_stream_page() {
        activityStreamPage.activityStreamButton.click();
        BrowserUtils.waitFor(1);
    }
    @When("the Activity Stream page is loaded")
    public void the_activity_stream_page_is_loaded() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("login.azulcrm.com/stream/"));
    }
    @Then("the user should see the following options")
    public void theUserShouldSeeTheFollowing(List<String> exceptedModules) {
        List<String> listOfOptions_String = new ArrayList<>();

        for (WebElement each : activityStreamPage.listOfOptions) {

            listOfOptions_String.add(each.getText());
        }

        System.out.println("listOfOptions_String = " + listOfOptions_String);
        Assert.assertEquals(exceptedModules,listOfOptions_String);

    }

    @When("the user clicks on the MORE tab")
    public void the_user_clicks_on_the_tab() {
        activityStreamPage.moreButton.click();
        BrowserUtils.waitFor(2);

    }
    @Then("the user should see the following options:")
    public void the_user_should_see_the_following_options (List<String> expectedOptions) {
        List<String> listOfOptions_String = new ArrayList<>();

        for (WebElement each : activityStreamPage.listOptions_MORE) {

            listOfOptions_String.add(each.getText());
        }

        System.out.println("listOfOptions_String = " + listOfOptions_String);
        Assert.assertEquals(expectedOptions,listOfOptions_String);


    }


}


