package com.epam.training.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class UsersPage extends AbstractPage {

    @FindBy(xpath = "//div[@class=\"task\"][3]//a[@class=\"task-link\"]")
    private WebElement createUserLink;

    @FindBy(xpath = "//a[@href=\"user/someuser/delete\"]")
    private WebElement deleteLink;

    public UsersPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CreateUserPage clickCreateUserLink() {
        createUserLink.click();
        return new CreateUserPage(driver);
    }

    public SomeUserPage clickDeleteLink() {
        deleteLink.click();
        return new SomeUserPage(driver);
    }

    public String isLinkPresent() {
        String result = null;
        if (createUserLink.isEnabled()) {
            result = createUserLink.getText();
        }
        return result;
    }


}








