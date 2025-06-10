package com.azulcrm.step_definitions;

import com.azulcrm.pages.AppreciationPage;
import com.azulcrm.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SendAppreciation_StepDefs {

    AppreciationPage appreciationPage = new AppreciationPage();


    @When("the user Send to {string}")
    public void theUserSendAn(String sendApp) {
        appreciationPage.SendAppreciation.sendKeys(sendApp);
    }

    @And("the user Click On {string}")
    public void theUserClickOn(String arg0) {
        appreciationPage.AllEmployees.click();
    }

    @Then("the user cancel sending appreciation")
    public void theUserCancelSendingAppreciation() {
appreciationPage.CancelAppreciation.click();


    }
}
