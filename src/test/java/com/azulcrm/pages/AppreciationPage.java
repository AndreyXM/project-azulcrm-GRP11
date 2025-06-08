package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppreciationPage {

public  AppreciationPage(){
    PageFactory.initElements(Driver.getDriver(),this);
}

@FindBy(xpath = "//span[@id='feed-add-post-form-link-text']")
    public WebElement SendAppreciation;

@FindBy(xpath = "//span[@class='feed-add-post-destination-text']")
    public WebElement AllEmployees;

@FindBy(xpath = "//button[@id='blog-submit-button-cancel']")
    public WebElement CancelAppreciation;
}
