package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DrivePage {

    public DrivePage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }
@FindBy(xpath = "//span[@class='menu-item-link-text']")
    public WebElement DriverMenu;

    @FindBy(xpath = "//span[@class='main-buttons-item-text-title']")
    public WebElement MyDrive;

     @FindBy(xpath = "//span[@class='main-buttons-item-text-title']")
    public WebElement AllDocument;

     @FindBy(xpath = "//span[@class='main-buttons-item-text']")
    public WebElement MoreOption;




}
