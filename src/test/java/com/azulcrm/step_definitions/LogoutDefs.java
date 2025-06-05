package com.azulcrm.step_definitions;

import com.azulcrm.pages.DashboardPage;
import com.azulcrm.utilities.BrowserUtils;
import io.cucumber.java.en.*;

public class LogoutDefs {

    DashboardPage dashboardPage = new DashboardPage();

    @When("the user clicks on profile link")
    public void the_user_clicks_on_profile_link() {
        dashboardPage.profileMenu.click();
    }

    @When("the user clicks on logout link")
    public void the_user_clicks_on_logout_link() {
        dashboardPage.logOutLink.click();
    }

    @Then("the user see autorization page")
    public void the_user_see_autorization_page() {
        String expectedTitle = "Authorization";
        BrowserUtils.verifyTitleContains(expectedTitle);
    }

}
