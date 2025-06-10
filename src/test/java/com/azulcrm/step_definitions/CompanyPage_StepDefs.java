package com.azulcrm.step_definitions;

import com.azulcrm.pages.CompanyPage;
import com.azulcrm.pages.DashboardPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class CompanyPage_StepDefs {
    @Then("User clicks Company under Activity Stream")
    public void user_clicks_company_under_activity_stream() {
        CompanyPage companyPage = new CompanyPage();
        companyPage.companyLink.click();
    }

    @Then("Verify users see the following modules in the Company page shown as design")
    public void verify_users_see_the_following_modules_in_the_company_page_shown_as_design(List<String> expectedModuleNames) {
        DashboardPage dashboardPage = new DashboardPage();
        List<String> actualModuleNames = dashboardPage.getModuleNames();

        Assert.assertEquals(expectedModuleNames, actualModuleNames);
    }
}
