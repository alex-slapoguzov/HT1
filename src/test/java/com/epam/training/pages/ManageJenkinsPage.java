package com.epam.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ManageJenkinsPage extends AbstractPage {

    @FindBy(xpath = "//td[@style=\"vertical-align:middle\"]//a[@href=\"securityRealm/\"]")
    private WebElement manageUsersLink;

    public ManageJenkinsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public UsersPage clickManageUsersLink() {
        manageUsersLink.click();
        return new UsersPage(driver);
    }

}
