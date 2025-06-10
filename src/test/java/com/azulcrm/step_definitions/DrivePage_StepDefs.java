package com.azulcrm.step_definitions;

import com.azulcrm.pages.DrivePage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Collections;
import java.util.List;

public class DrivePage_StepDefs {

    DrivePage drivePage=new DrivePage();



    @When("I navigate to the Drive page")
    public void i_navigate_to_the_drive_page() {
        drivePage.DriverMenu.click();
        BrowserUtils.waitFor(2);

        drivePage.MyDrive.click();
        BrowserUtils.waitForVisibility(drivePage.AllDocument,2);

    }

    @When("Verify the users view the following 6 modules")
    public void Verify_the_users_view_the_following_6_modules(List<String> expectedModules ) {
    List <String> actualModules =BrowserUtils.getElementsText(Collections.singletonList(drivePage.DriverMenu));
        Assert.assertEquals(actualModules,expectedModules);
    }

    @Then("the user click on More option")
    public void theUserClickOnMoreOption() {
        drivePage.MoreOption.click();
    }

    @Then("the user see {string}")
    public void the_user_see(String options) {

        if (options.equalsIgnoreCase("hr")) {
            Assert.assertEquals(ConfigurationReader.getProperty("hr_username"), drivePage.DriverMenu.getText());
        } else if (options.equalsIgnoreCase("helpdesk")) {
            Assert.assertEquals(ConfigurationReader.getProperty("helpdesk_username"), drivePage.DriverMenu.getText());
        } else if (options.equalsIgnoreCase("marketing")) {
        Assert.assertEquals(ConfigurationReader.getProperty("marketing_username"), drivePage.DriverMenu.getText());
    }

    }



}
