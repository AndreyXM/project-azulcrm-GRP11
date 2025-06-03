package com.azulcrm.step_definitions;

import com.azulcrm.pages.LoginPage;
import com.azulcrm.pages.ProfilePage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.ConfigurationReader;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class ProfilePageStepDefs {
    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage = new ProfilePage();

    @Given("user logs in as hr user")
    public void userLogsAsHrUser() {
        Driver.getDriver().get("https://qa.azulcrm.com/");
        loginPage.login(ConfigurationReader.getProperty("hr_username"), ConfigurationReader.getProperty("hr_password"));
    }

    @Given("user logs in as helpdesk user")
    public void userLogsInAsHelpdeskUser() {
        Driver.getDriver().get("https://qa.azulcrm.com/");
        loginPage.login(ConfigurationReader.getProperty("helpdesk_username"), ConfigurationReader.getProperty("helpdesk_password"));
    }

    @Given("user logs in as marketing user")
    public void userLogsInAsMarketingUser() {
        Driver.getDriver().get("https://qa.azulcrm.com/");
        loginPage.login(ConfigurationReader.getProperty("marketing_username"), ConfigurationReader.getProperty("marketing_password"));
    }

    @When("user clicks on My Profile option under the user menu.")
    public void user_clicks_on_my_profile_option_under_the_user_menu() {
        profilePage.userMenu.click();
        BrowserUtils.waitFor(3);
        profilePage.myProfileItem.click();
        BrowserUtils.waitForVisibility(profilePage.generalItem, 10);
    }

    @And("user sees his her hr email in the title.")
    public void userSeesHisHerHrEmailInTheTitle() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(ConfigurationReader.getProperty("hr_username")));
    }

    @And("user sees his her helpdesk email in the title.")
    public void userSeesHisHerHelpdeskEmailInTheTitle() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(ConfigurationReader.getProperty("helpdesk_username")));
    }

    @And("user sees his her marketing email in the title.")
    public void userSeesHisHerMarketingEmailInTheTitle() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(ConfigurationReader.getProperty("marketing_username")));
    }

    @When("user views the following options on My Profile page")
    public void user_views_the_following_options_on_my_profile_page(List<String> expectedOptions) {
        BrowserUtils.waitFor(10);
        List<String> actualOptions = BrowserUtils.getElementsText(profilePage.profileMenuItems);
        Assert.assertEquals(expectedOptions, actualOptions);
    }

    @Then("user sees his her hr email under the general tab")
    public void userSeesHisHerHrEmailUnderTheGeneralTab() {
        String actualEmail = profilePage.confirmationEmail.getText();
        String expectedEmail = ConfigurationReader.getProperty("hr_username");
        Assert.assertEquals(expectedEmail, actualEmail);
    }

    @Then("user sees his her helpdesk email under the general tab")
    public void userSeesHisHerHelpdeskEmailUnderTheGeneralTab() {
        String actualEmail = profilePage.confirmationEmail.getText();
        String expectedEmail = ConfigurationReader.getProperty("helpdesk_username");
        Assert.assertEquals(expectedEmail, actualEmail);
    }

    @Then("user sees his her marketing email under the general tab")
    public void userSeesHisHerMarketingEmailUnderTheGeneralTab() {
        String actualEmail = profilePage.confirmationEmail.getText();
        String expectedEmail = ConfigurationReader.getProperty("marketing_username");
        Assert.assertEquals(expectedEmail, actualEmail);
    }
    //TODO: Look for some alternatives--->Given user logs in as hr-helpdesk-marketing user steps all together
    //TODO: Look for some alternatives--->And user sees his her hr-helpdesk-marketing email in the title steps all together
    //TODO: Look for some alternatives--->Given user logs in as hr-helpdesk-marketing user steps all together



}
