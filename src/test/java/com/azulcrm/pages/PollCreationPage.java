package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PollCreationPage {
    public PollCreationPage(){
        PageFactory.initElements (Driver.getDriver (),this);
    }
    @FindBy(xpath = "//tbody//span//span[.='Poll']")
    public WebElement pollButton;

    @FindBy(xpath = "//body[@contenteditable='true']")
    public WebElement messageTitleBox;

    @FindBy(xpath = "//tbody//input[@placeholder='Question ']")
    public WebElement questionBox;

    @FindBy(xpath = "//tbody//input[@placeholder='Answer  1']")
    public WebElement answerBox1;

    @FindBy(xpath = "//tbody//input[@placeholder='Answer  2']")
    public WebElement answerBox2;

    @FindBy(xpath = "//tbody//input[@class='vote-checkbox']")
    public WebElement multipleChoiceBox;

    @FindBy(xpath = "//tbody//button[@id='blog-submit-button-save']")
    public WebElement pollSendButton;

    @FindBy(xpath = "//span[@class='feed-add-info-text']")
    public WebElement messageTitleHeader;

    @FindBy(xpath = "//span[@class='feed-add-post-del-but']")
    public WebElement recipientBoxDelete;

    @FindBy(xpath = "//a[@id='bx-destination-tag']")
    public WebElement addRecipientLink;

    @FindBy(xpath = "(//ol//input[@type='text'])[1]")
    public WebElement recipientBox;

    @FindBy(xpath = "//span[@class='feed-add-info-text']")
    public WebElement questionTitleHeader;

}
