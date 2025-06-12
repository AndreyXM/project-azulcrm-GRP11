package com.azulcrm.step_definitions;

import com.azulcrm.pages.DashboardPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class CompanyPage_StepDefs {
    DashboardPage dashboardPage = new DashboardPage();

    @Then("Verify users see the following modules in the Company page shown as design")
    public void verify_users_see_the_following_modules_in_the_company_page_shown_as_design(List<String> expectedModuleNames) {
        List<String> actualModuleNames = dashboardPage.getModuleNames();
        Assert.assertEquals(expectedModuleNames, actualModuleNames);
    }

    @And("the user clicks side menu {string}")
    public void theUserClicksSideMenu(String sideMenuName) {
        dashboardPage.clickOnSideMenuByText(sideMenuName);
    }
}