package com.azulcrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class ProfilePage extends BaseDashboardPage{
    @FindBy(xpath = "//div[@class='profile-menu-items']//a")
    public List<WebElement> profileMenuItems;

    @FindBy(xpath = "//td[@class='user-profile-nowrap-second']/a")
    public WebElement confirmationEmail;
}
