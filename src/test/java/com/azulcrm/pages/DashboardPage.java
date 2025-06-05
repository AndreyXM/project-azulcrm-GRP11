package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DashboardPage {

    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="user-name")
    public WebElement profileMenu;

    @FindBy(xpath="//span[.='Log out']")
    public WebElement logOutLink;

    @FindBy(id = "feed-add-post-form-tab-message")
    public WebElement MessageLink;

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



    //

}
