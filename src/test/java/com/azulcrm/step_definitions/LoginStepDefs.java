package com.azulcrm.step_definitions;

import com.azulcrm.pages.HomePage;
import com.azulcrm.pages.LoginPage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.ConfigurationReader;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LoginStepDefs {

    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();

        homePage.logInLink.click();

        if (userType.equalsIgnoreCase("hr")) {
            loginPage.login(ConfigurationReader.getProperty("hr_username"), ConfigurationReader.getProperty("hr_password"));
        } else if (userType.equalsIgnoreCase("helpdesk")) {
            loginPage.login(ConfigurationReader.getProperty("helpdesk_username"), ConfigurationReader.getProperty("helpdesk_password"));
        } else if (userType.equalsIgnoreCase("marketing")) {
            loginPage.login(ConfigurationReader.getProperty("marketing_username"), ConfigurationReader.getProperty("marketing_password"));
        }
    }

    @Then("the user see dashboard page")
    public void the_user_see_dashboard_page() {
        String expectedTitle = "Portal";
        BrowserUtils.verifyTitleContains(expectedTitle);
    }


}
