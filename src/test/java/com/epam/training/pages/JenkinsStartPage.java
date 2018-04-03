package com.epam.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class JenkinsStartPage extends AbstractPage {

    @FindBy(xpath = "//div[@class=\"task\"][4]//a[@class=\"task-link\"]")
    private WebElement manageJenkinsLink;

    @FindBy(xpath = "//div[@id=\"right-top-nav\"]//a")
    private WebElement autoRefreshButton;


    public JenkinsStartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public ManageJenkinsPage clickManageJenkinsLink() {
        manageJenkinsLink.click();
        return new ManageJenkinsPage(driver);
    }

    public String getTextButton() {
        return autoRefreshButton.getText();
    }

    public void clickButton() {
        autoRefreshButton.click();
    }
}
