package com.azulcrm.step_definitions;

import com.azulcrm.pages.CompanyDashboardPage;
import com.azulcrm.pages.CompanyPage;
import com.azulcrm.pages.HomePage;
import com.azulcrm.pages.LoginPage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class CompanyPage_StepDefs {

    @Given("User is logged in as a {string}")
    public void user_is_logged_in_as_a(String userType) {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();

        homePage.logInLink.click();

        BrowserUtils.waitFor(2);

        if (userType.equalsIgnoreCase("hr1")) {
            loginPage.login(ConfigurationReader.getProperty("hr_username"), ConfigurationReader.getProperty("hr_password"));
        } else if (userType.equalsIgnoreCase("helpdesk1")) {
            loginPage.login(ConfigurationReader.getProperty("helpdesk_username"), ConfigurationReader.getProperty("helpdesk_password"));
        } else if (userType.equalsIgnoreCase("marketing1")) {
            loginPage.login(ConfigurationReader.getProperty("marketing_username"), ConfigurationReader.getProperty("marketing_password"));
        }

    }
    @Then("User clicks Company under Activity Stream")
    public void user_clicks_company_under_activity_stream() {
        CompanyPage companyPage = new CompanyPage();
        companyPage.companyLink.click();
    }
        CompanyDashboardPage companyDashboardPage;
    @Then("Verify users see the following modules in the Company page shown as design")
    public void verify_users_see_the_following_modules_in_the_company_page_shown_as_design(List<String> expectedModuleNames) {
        companyDashboardPage = new CompanyDashboardPage();
        List<String> actualModuleNames = companyDashboardPage.getModuleNames();

        Assert.assertEquals(expectedModuleNames, actualModuleNames);


    }

}
