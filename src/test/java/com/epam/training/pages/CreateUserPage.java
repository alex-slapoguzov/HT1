package com.epam.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreateUserPage extends AbstractPage {
  private WebDriverWait wait = new WebDriverWait(driver, 30);

    @FindBy(name = "username")
    private WebElement usernameInForm;

    @FindBy(name = "password1")
    private WebElement passwordInForm;

    @FindBy(name = "password2")
    private WebElement confirmPasswordInForm;

    @FindBy(name = "fullname")
    private WebElement fullNameInForm;

    @FindBy(name = "email")
    private WebElement emailAddressInForm;

    @FindBy(id = "yui-gen4-button")
    private WebElement createUserButton;

    @FindBy(xpath = "//div[@id=\"main-panel\"]//div[@class=\"error\"]")
    private WebElement errorMessage;

    public CreateUserPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void typeUsername(String name) {
        usernameInForm.clear();
        usernameInForm.sendKeys(name);
    }

    public void typePassword(String password) {
        passwordInForm.clear();
        passwordInForm.sendKeys(password);
    }

    public void typeConfirmPassword(String password) {
        confirmPasswordInForm.clear();
        confirmPasswordInForm.sendKeys(password);
    }

    public void typeFullName(String fullName) {
        fullNameInForm.clear();
        fullNameInForm.sendKeys(fullName);
    }

    public void typeEmailAddress(String email) {
        emailAddressInForm.clear();
        emailAddressInForm.sendKeys(email);
    }

    public UsersPage clickCreateUserButton() {
        createUserButton.click();
        return new UsersPage(driver);
    }

    public String getErrorMessage(){
       return errorMessage.getText();
    }

    public UsersPage submitFilledForm(String name, String password, String fullName, String email) {
        typeUsername(name);
        typePassword(password);
        typeConfirmPassword(password);
        typeFullName(fullName);
        typeEmailAddress(email);
        return clickCreateUserButton();
    }

    public String getColor(){
        return createUserButton.getCssValue("background-color");
    }

}
