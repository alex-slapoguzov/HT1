package com.epam.training.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends AbstractPage {

    @FindBy(id = "j_username")
    private WebElement loginField;

    @FindBy(name = "j_password")
    private WebElement passwordField;

    @FindBy(id = "yui-gen1-button")
    private WebElement inputButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void typeEmailUserField(String user) {
        loginField.clear();
        loginField.sendKeys(user);
    }

    public void typePasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public JenkinsStartPage clickLogInButton() {
        inputButton.click();
        return new JenkinsStartPage(driver);
    }

    public JenkinsStartPage submitFilledForm(String user, String password) {
        typeEmailUserField(user);
        typePasswordField(password);
        return clickLogInButton();
    }

    public String getColor(){
        return inputButton.getCssValue("background-color");
    }
}
