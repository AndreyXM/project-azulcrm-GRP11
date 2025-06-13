package com.azulcrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SendMessagePage extends BaseDashboardPage{

    @FindBy(xpath = "//body[@contenteditable='true']")
    public WebElement messageTitleBox;

    @FindBy(xpath = "//span[@class='feed-add-post-del-but']")
    public WebElement recipientBoxDelete;

    @FindBy(xpath = "//a[@id='bx-destination-tag']")
    public WebElement addRecipientLink;

    @FindBy(id ="feed-add-post-destination-input")
    public WebElement recipientBox;

    @FindBy(xpath = "//span[.='All employees']")
    public WebElement defaultAddEmployee;

    @FindBy(xpath = "((//a[@class = 'feed-post-user-name'])[1])")
    public WebElement sender;

    @FindBy(xpath = "((//a[@class = 'feed-add-post-destination-new'])[1])")
    public WebElement receiver;

    @FindBy(xpath = "((//div[@class = 'feed-post-text-block-inner-inner'])[1])")
    public WebElement textDisplayed;
}
