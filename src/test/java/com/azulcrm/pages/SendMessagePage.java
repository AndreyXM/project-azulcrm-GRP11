package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendMessagePage {
    public SendMessagePage(){
        PageFactory.initElements (Driver.getDriver (),this);
    }

    @FindBy(xpath = "//span[.='Message']")
    public WebElement messageButton;

    @FindBy(xpath = "//body[@contenteditable='true']")
    public WebElement messageTitleBox;

    @FindBy(xpath = "//body[@contenteditable='true']")
    public WebElement messagecontent;

    @FindBy(xpath = "//button[@id='blog-submit-button-save']")
    public WebElement sendButton;

    @FindBy(xpath = "//span[@class='feed-add-post-destination-text']")
    public WebElement addEmployeeButton;

    @FindBy(xpath = "//span[@class='feed-add-post-del-but']")
    public WebElement recipientBoxDelete;

    @FindBy(xpath = "//a[@id='bx-destination-tag']")
    public WebElement addRecipientLink;

    @FindBy(id ="feed-add-post-destination-input")
    public WebElement recipientBox;

    @FindBy(xpath = "//button[@id='blog-submit-button-cancel']")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@class='feed-post-text-block-inner-inner']")
    public WebElement displayedMessage;

    @FindBy(xpath = "//span[.='All employees']")
    public WebElement defaultAddEmployee;

    @FindBy(xpath = "(//div[@class='feed-post-block feed-post-block-short feed-post-block-separator'])[1]")
    public WebElement newMessageBox;

    @FindBy(xpath = "((//a[@class = 'feed-post-user-name'])[1])")
    public WebElement sender;

    @FindBy(xpath = "((//a[@class = 'feed-add-post-destination-new'])[1])")
    public WebElement receiver;

    @FindBy(xpath = "((//div[@class = 'feed-post-text-block-inner-inner'])[1])")
    public WebElement textDisplayed;


















}
