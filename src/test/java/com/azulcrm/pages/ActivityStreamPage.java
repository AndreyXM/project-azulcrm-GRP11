package com.azulcrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActivityStreamPage extends BaseDashboardPage {

    @FindBy(xpath = "//span[@title='Link']")
    public WebElement addLinkBtn;

    @FindBy(xpath = "//input[@placeholder='Link text']")
    public WebElement linkTextInput;

    @FindBy(xpath = "//input[@placeholder='Link URL']")
    public WebElement linkURLInput;

    @FindBy(xpath = "//input[@value='Save']")
    public WebElement saveBtn;

    @FindBy(xpath = "(//div[@class='feed-post-text-block']//a)[1]")
    public WebElement messageLink;

    @FindBy(xpath = "//span[contains(text(),'You have already added your post')]")
    public WebElement duplicateMessageError;

    @FindBy(xpath = "//a[@title='Activity Stream']")
    public WebElement activityStreamButton;

    @FindBy(xpath = "//div[@id='feed-add-post-form-tab']/span")
    public List<WebElement> listOfOptions;

    @FindBy(id = "feed-add-post-form-link-text")
    public WebElement moreButton;

    @FindBy(xpath = "//span[@class='menu-popup-item-text']")
    public List<WebElement> listOptions_MORE;

}
