package com.epam.training.actions;

import com.epam.training.driver.ChromeDriverSettings;
import com.epam.training.pages.*;
import org.openqa.selenium.WebDriver;

public class Actions {

    private WebDriver driver;

    public void initBrowser() {
        driver = ChromeDriverSettings.getDriver();
    }

    public void closeDriver() {
        ChromeDriverSettings.closeDriver();
    }

    public void loginJenkins(String user, String password, String BASE_URL) {
        driver.get(BASE_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.submitFilledForm(user, password);
    }

    public void clickToLinkManageJenkins() {
        JenkinsStartPage jenkinsStartPage = new JenkinsStartPage(driver);
        jenkinsStartPage.clickManageJenkinsLink();
    }

    public void clickToLinkManageUsers() {
        ManageJenkinsPage manageJenkinsPage = new ManageJenkinsPage(driver);
        manageJenkinsPage.clickManageUsersLink();
    }

    public void clickToLinkDelete() {
        UsersPage usersPage = new UsersPage(driver);
        usersPage.clickDeleteLink();
    }

    public String getLink() {
        UsersPage usersPage = new UsersPage(driver);
        return usersPage.isLinkPresent();
    }

    public String getText() {
        SomeUserPage someUserPage = new SomeUserPage(driver);
        return someUserPage.getTextConfirmation();
    }

    public void clickToLinkCreateUser() {
        UsersPage usersPage = new UsersPage(driver);
        usersPage.clickCreateUserLink();
    }

    public void submitForm(String name, String password, String fullName, String email) {
        CreateUserPage createUserPage = new CreateUserPage(driver);
        createUserPage.submitFilledForm(name, password, fullName, email);
    }

    public void clickYesButton() {
        SomeUserPage someUserPage = new SomeUserPage(driver);
        someUserPage.clickYesButton();
    }

    public void submitFormWithEmptyUser(String name, String password, String fullName, String email){
        JenkinsStartPage jenkinsStartPage = new JenkinsStartPage(driver);
        jenkinsStartPage.clickManageJenkinsLink();
        ManageJenkinsPage manageJenkinsPage = new ManageJenkinsPage(driver);
        manageJenkinsPage.clickManageUsersLink();
        UsersPage usersPage = new UsersPage(driver);
        usersPage.clickCreateUserLink();
        submitForm(name, password, fullName, email);
    }

    public String getMessage() {
        CreateUserPage createUserPage = new CreateUserPage(driver);
        return createUserPage.getErrorMessage();
    }

    public String getTextAutoRefreshButtons() {
        JenkinsStartPage jenkinsStartPage = new JenkinsStartPage(driver);
        return jenkinsStartPage.getTextButton();
    }


    public void clickAutoRefreshButton() {
        JenkinsStartPage jenkinsStartPage = new JenkinsStartPage(driver);
        jenkinsStartPage.clickButton();
    }

    public String getInputButtonColor(){
        LoginPage loginPage = new LoginPage(driver);
     return    loginPage.getColor();
    }

    public String getCreateUserButtonColor(){
        CreateUserPage createUserPage = new CreateUserPage(driver);
        return    createUserPage.getColor();
    }

    public String getYesButtonColor(){
        SomeUserPage someUserPage = new SomeUserPage(driver);
        return    someUserPage.getColor();
    }

    public void goToCreateUserButton(){
        clickToLinkManageJenkins();
        clickToLinkManageUsers();
        clickToLinkCreateUser();
    }

    public void goToYesButton(String name, String password, String fullName, String email) {
        submitForm(name, password, fullName, email);
        clickToLinkDelete();
    }
}
