package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActivityStreamPage {

    public ActivityStreamPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='Send message …']")
    public WebElement sendMessageField;

    @FindBy(xpath = "//span[@title='Link']")
    public WebElement addLinkBtn;

    @FindBy(xpath = "//input[@placeholder='Link text']")
    public WebElement linkTextInput;

    @FindBy(xpath = "//input[@placeholder='Link URL']")
    public WebElement linkURLInput;

    @FindBy(xpath = "//input[@value='Save']")
    public WebElement saveBtn;

    @FindBy(xpath = "//div[@class='feed-post-text-block']//a")
    public WebElement messageLink;
}
