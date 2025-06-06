package com.azulcrm.pages;

import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CompanyDashboardPage {

    public CompanyDashboardPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = "span.main-buttons-item-text-title")
    private List<WebElement> moduleNames;

    public List<String> getModuleNames() {
        // BrowserUtils.waitForVisibility(moduleElements.get(0),10);

        return BrowserUtils.getElementsText(this.moduleNames);
    }
}
