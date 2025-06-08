package com.azulcrm.step_definitions;

import com.azulcrm.pages.DashboardPage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

public class UploadFilesAsMsgDefs {
    DashboardPage dashboardPage = new DashboardPage();

    @Then("the user clicks on Message")
    public void the_user_clicks_on_message() {
        dashboardPage.MessageLink.click();
    }

    @When("the user clicks on Upload Files")
    public void the_user_clicks_on_upload_files() {
        dashboardPage.UploadFilesButton.click();
    }

    @When("the user clicks on Upload Files and Images to select file {string}")
    public void the_user_clicks_on_upload_files_and_images_to_select_file(String fileNameToUpload) {
        String fullFileName = System.getProperty("user.dir") +
                File.separator + "testing-files" +
                File.separator + fileNameToUpload;

        dashboardPage.UploadFilesAndImagesLinks.sendKeys(fullFileName);
    }

    @When("the user click on Insert In Text")
    public void the_user_click_on_insert_in_text() {
        dashboardPage.InsertInTextButton.click();
    }

    @Then("the user see file {string} in Message window")
    public void the_user_see_selected_in_message_window(String fileName) {
        Driver.getDriver().switchTo().frame(dashboardPage.iframeEditMsg);

        WebElement addedFile = Driver.getDriver().findElement(By.xpath(getDynamicLocatorByFileName(fileName)));

        BrowserUtils.waitForVisibility(addedFile, 5);
        Assert.assertTrue(addedFile.isDisplayed());
    }

    @When("the user click on Remove Files and Images")
    public void the_user_click_on_remove_files_and_images() {
        dashboardPage.RemoveFileFromMsg.click();
    }

    @Then("the user not see selected {string} in Message window")
    public void the_user_not_see_selected_in_message_window(String fileName) {
        Driver.getDriver().switchTo().frame(dashboardPage.iframeEditMsg);
        List<WebElement> addedFile = Driver.getDriver().findElements(By.xpath(getDynamicLocatorByFileName(fileName)));
        Assert.assertTrue(addedFile.isEmpty());
    }

    @Then("the user should not see file {string} in Message window")
    public void the_user_should_not_see_file_in_message_window(String fileName) {
        Driver.getDriver().switchTo().frame(dashboardPage.iframeEditMsg);

        String locator;
        if (fileName.toLowerCase().endsWith(".bmp")) {
            String fileNameWithoutExt = fileName.substring(0, fileName.lastIndexOf("."));
            locator = "//img[contains(@src, '" + fileNameWithoutExt + "')]";

        } else {
            locator = "//span[.='" + fileName + "']";
        }

        List<WebElement> addedFile = Driver.getDriver().findElements(By.xpath(locator));
        Assert.assertTrue("The unsupported file " + fileName + " added to the message", addedFile.isEmpty());
    }

    public String getDynamicLocatorByFileName(String fileName){
        String locator;
        if (fileName.toLowerCase().endsWith(".png") ||
                fileName.toLowerCase().endsWith(".jpg") ||
                fileName.toLowerCase().endsWith(".jpeg")) {

            String fileNameWithoutExt = fileName.substring(0, fileName.lastIndexOf("."));
            locator = "//img[contains(@src, '" + fileNameWithoutExt + "')]";

        } else {
            locator = "//span[.='" + fileName + "']";
        }

        return locator;
    }
}
