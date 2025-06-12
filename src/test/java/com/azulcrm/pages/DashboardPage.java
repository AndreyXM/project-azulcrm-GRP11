package com.azulcrm.pages;

import com.azulcrm.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardPage extends BaseDashboardPage{

    @FindBy(id="bx-b-uploadfile-blogPostForm")
    public WebElement UploadFilesButton;

    @FindBy(xpath = "//input[@name='bxu_files[]']")
    public WebElement UploadFilesAndImagesLinks;

    @FindBy(xpath = "//span[@class='insert-btn-text' and .='Insert in text']")
    public WebElement InsertInTextButton;

    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    public WebElement iframeEditMsg;

    @FindBy(xpath = "//td[@class='files-del-btn']/span")
    public WebElement RemoveFileFromMsg;

    @FindBy(css = "span.main-buttons-item-text-title")
    private List<WebElement> moduleNames;

    public List<String> getModuleNames() {
        return BrowserUtils.getElementsText(this.moduleNames);
    }

}
