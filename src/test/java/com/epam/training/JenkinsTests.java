package com.epam.training;


import com.epam.training.actions.Actions;
import com.epam.training.validators.Validators;
import org.testng.Assert;
import org.testng.annotations.*;


public class JenkinsTests {

    //Run with testng.xml
    private Actions actions;
    private Validators validators;

    @Parameters({"userForLogIn", "passwordForLogIn", "BASE_URL"})
    @BeforeClass
    public void setUp(String userForLogIn, String passwordForLogIn, String BASE_URL) {
        validators = new Validators();
        actions = new Actions();
        actions.initBrowser();
        actions.loginJenkins(userForLogIn, passwordForLogIn, BASE_URL);
    }

    @AfterClass()
    public void stopBrowser() {
        actions.closeDriver();
    }


    @Parameters({"tagname1", "tagname2", "manageUsersText1", "manageUsersText2"})
    @Test
    public void testManageJenkins(String tagname1, String tagname2, String manageUsersText1, String manageUsersText2) {
        actions.clickToLinkManageJenkins();
        Assert.assertTrue(validators.checkElementPresentWithTagNameAndText(tagname1, manageUsersText1), "[Element " + tagname1 + " with text " + manageUsersText1 + " is absent]");
        Assert.assertTrue(validators.checkElementPresentWithTagNameAndText(tagname2, manageUsersText2), "[Element " + tagname2 + " with text " + manageUsersText2 + " is absent]");
    }


    @Test()
    public void testManageUsers() {
        actions.clickToLinkManageUsers();
        String link = actions.getLink();
        Assert.assertTrue(validators.checkLinkPresent(link), "Link isn't present");
    }

    @Test()
    public void testCreateUser() {
        actions.clickToLinkCreateUser();
        Assert.assertTrue(validators.checkFormPresent(), "[Form with fields of type text and password isn't present]");
        Assert.assertTrue(validators.checkFieldsInFormEmpty(), "[All fields in form aren't empty]");
    }


    @Parameters({"userForTest", "passwordForTest", "fullNameForTest", "emailAddressForTest", "tagname3", "tagname4"})
    @Test
    public void testCreateNewUser(String userForTest, String passwordForTest, String fullNameForTest, String emailAddressForTest, String tagname3, String tagname4) {
        actions.submitForm(userForTest, passwordForTest, fullNameForTest, emailAddressForTest);
        Assert.assertTrue(validators.checkTextPresent(tagname3, tagname4, userForTest), "Element with text someuser absent!");
    }


    @Parameters({"textConfirmation"})
    @Test
    public void testDeleteButton(String textConfirmation) {
        actions.clickToLinkDelete();
        String text = actions.getText();
        Assert.assertTrue(validators.checkTextConfirmation(text, textConfirmation), "[Text ]" + textConfirmation + "[ isn't present]");
    }


    @Parameters({"tagname3", "tagname4", "userForTest", "textHrefAttribute1"})
    @Test
    public void testDeleteUser(String tagname3, String tagname4, String userForTest, String textHrefAttribute1) {
        actions.clickYesButton();
        Assert.assertFalse(validators.checkTextPresent(tagname3, tagname4, userForTest), "Element is on the page");
        Assert.assertFalse(validators.checkLinkWithHrefPresent(textHrefAttribute1), "Link is on the page");
    }


    @Parameters({"textHrefAttribute2"})
    @Test
    public void testLinkWithHrefPresent(String textHrefAttribute2) {
        Assert.assertFalse(validators.checkLinkWithHrefPresent(textHrefAttribute2), "Link is on the page");
    }



}
