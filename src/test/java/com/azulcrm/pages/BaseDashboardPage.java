package com.azulcrm.pages;

import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseDashboardPage {

    public BaseDashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="user-name")
    public WebElement userMenu;

    @FindBy(id="blog-submit-button-save")
    public WebElement sendButton;

    @FindBy(id="blog-submit-button-cancel")
    public WebElement cancelButton;

    public void clickOnMainMenuByText(String mainMenuName){
        WebElement menuElement = Driver.getDriver().findElement(By.xpath("//span[.='"+mainMenuName+"']"));
        menuElement.click();
    }

    public void clickOnSideMenuByText(String sideMenuName){
        WebElement menuElement = Driver.getDriver().findElement(By.xpath("//span[normalize-space()='"+sideMenuName+"']"));
        menuElement.click();
    }

    public void clickOnSubmenuInUserMenuByText(String subMenuName){
        WebElement menuElement = Driver.getDriver().findElement(By.xpath("//span[@class='menu-popup-item-text' and text()='"+subMenuName+"']"));
        menuElement.click();
    }

}
