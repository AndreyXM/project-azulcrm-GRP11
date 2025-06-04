package com.azulcrm.pages;

import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ProfilePage {
    public ProfilePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "user-block")
    public WebElement userMenu;

    //div[@class='menu-popup-items']//span[.='My Profile']
    //(//span[@class='menu-popup-item-text'])[1]
    //div[@class='menu-popup-items']//span[@class='menu-popup-item-text'])[1]
    //(//a[@class='menu-popup-item menu-popup-no-icon '])[1]
    //span[normalize-space()='My Profile']
    //div[@id='menu-popup-user-menu']//span[.='My Profile']

    @FindBy (xpath = "//span[normalize-space()='My Profile']")
    public WebElement myProfileItem;

    @FindBy (xpath = "//a[.='General']")
    public WebElement generalItem;

    @FindBy (xpath = "//div[@class='profile-menu-items']//a")
    public List<WebElement> profileMenuItems;

    @FindBy (xpath = "//td[@class='user-profile-nowrap-second']/a")
    public WebElement confirmationEmail;
}
