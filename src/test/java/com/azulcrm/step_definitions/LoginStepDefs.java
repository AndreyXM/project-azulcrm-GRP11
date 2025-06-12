package com.azulcrm.step_definitions;

import com.azulcrm.pages.HomePage;
import com.azulcrm.pages.LoginPage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.ConfigurationReader;
import io.cucumber.java.en.*;

public class LoginStepDefs {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    String expectedLoginTitle = "Authorization";

    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {
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
        BrowserUtils.waitForTitleContains(expectedTitle);
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        homePage.logInLink.click();
        BrowserUtils.waitForTitleContains(expectedLoginTitle);
    }

    @When("the user enters an username {string} and password {string}")
    public void the_user_enters_an_username_and_password(String userName, String password) {
        loginPage.login(userName, password);
    }

    @Then("the login should failed")
    public void the_login_should_failed() {
        BrowserUtils.waitForTitleContains(expectedLoginTitle);
    }

    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() {
        BrowserUtils.verifyElementDisplayed(loginPage.errorMsg);
    }
}