package com.azulcrm.step_definitions;

import com.azulcrm.pages.DashboardPage;
import com.azulcrm.utilities.BrowserUtils;
import io.cucumber.java.en.*;

public class LogoutDefs {

    DashboardPage dashboardPage = new DashboardPage();

    @When("the user clicks on user Menu link")
    public void the_user_clicks_on_user_menu_link() {
        dashboardPage.userMenu.click();
    }

    @Then("the user see authorization page")
    public void the_user_see_authorization_page() {
        String expectedTitle = "Authorization";
        BrowserUtils.verifyTitleContains(expectedTitle);
    }

    @And("the user clicks on {string} link under user Menu")
    public void theUserClicksOnLinkUnderMenu(String submenuName) {
        dashboardPage.clickOnSubmenuInUserMenuByText(submenuName);
    }
}