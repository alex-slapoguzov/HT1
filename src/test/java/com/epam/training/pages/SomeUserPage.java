package com.epam.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SomeUserPage extends AbstractPage {

    @FindBy(id = "yui-gen4-button")
    private WebElement yesButton;

    @FindBy(xpath = "//form[@name=\"delete\"]")
    private WebElement formWithText;

    public SomeUserPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public UsersPage clickYesButton() {
        yesButton.click();
        return new UsersPage(driver);
    }

    public String getTextConfirmation() {
        return formWithText.getText();
    }

    public String getColor(){
        return yesButton.getCssValue("background-color");
    }
}
