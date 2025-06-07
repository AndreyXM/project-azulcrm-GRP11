package com.azulcrm.step_definitions;
import com.azulcrm.pages.ProfilePage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.util.List;

public class ProfilePageStepDefs {

//TODO : Then the user sees the "<userType>" email under the general tab ->create separate scenario!
ProfilePage profilePage = new ProfilePage();

    @When("the user clicks on My Profile option under the User Menu")
    public void user_clicks_on_my_profile_option_under_the_user_menu() {
        profilePage.userMenu.click();
        BrowserUtils.waitFor(1);
        profilePage.myProfileItem.click();
        BrowserUtils.waitForVisibility(profilePage.generalItem, 10);
    }

    @When("the user views the following options on My Profile page")
    public void user_views_the_following_options_on_my_profile_page(List<String> expectedOptions) {
        List<String> actualOptions = BrowserUtils.getElementsText(profilePage.profileMenuItems);
        Assert.assertEquals(expectedOptions, actualOptions);
    }

    @Then("the user sees the {string} email under the general tab")
    public void userSeesHisHerUnderTheGeneralTab(String userType) {
        if (userType.equalsIgnoreCase("hr")) {
            Assert.assertEquals(ConfigurationReader.getProperty("hr_username"), profilePage.confirmationEmail.getText());
        } else if (userType.equalsIgnoreCase("helpdesk")) {
            Assert.assertEquals(ConfigurationReader.getProperty("helpdesk_username"), profilePage.confirmationEmail.getText());
        } else if (userType.equalsIgnoreCase("marketing")) {
            Assert.assertEquals(ConfigurationReader.getProperty("marketing_username"), profilePage.confirmationEmail.getText());
        }
    }

}
