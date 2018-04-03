package com.epam.training;

import com.epam.training.actions.Actions;
import com.epam.training.validators.Validators;
import org.testng.Assert;
import org.testng.annotations.*;

public class JenkinsAdditionalTests {

    //Run with testngAdditionalTasks.xml
    private Actions actions;
    private Validators validators;

    @Parameters({"userForLogIn", "passwordForLogIn", "BASE_URL"})
    @BeforeMethod
    public void setUp(String userForLogIn, String passwordForLogIn, String BASE_URL) {
        validators = new Validators();
        actions = new Actions();
        actions.initBrowser();
        actions.loginJenkins(userForLogIn, passwordForLogIn, BASE_URL);
    }

    @AfterMethod()
    public void stopBrowser() {
        actions.closeDriver();
    }

    @Parameters({"color", "userForTest", "passwordForTest", "fullNameForTest", "emailAddressForTest"})
    @Test
    public void testColorButtons(String color, String userForTest, String passwordForTest, String fullNameForTest, String emailAddressForTest) {
        String currentColor = actions.getInputButtonColor();
        Assert.assertTrue(validators.checkButtonColor(currentColor, color), "[Current color InputButton in LoginPage is " + currentColor + "]");
        actions.goToCreateUserButton();
        currentColor = actions.getCreateUserButtonColor();
        Assert.assertTrue(validators.checkButtonColor(currentColor, color), "[Current color CreateUserButton in CreateUserPage is " + currentColor + "]");
        actions.goToYesButton(userForTest, passwordForTest, fullNameForTest, emailAddressForTest);
        currentColor = actions.getYesButtonColor();
        Assert.assertTrue(validators.checkButtonColor(currentColor, color), "[Current color YesButton in SomeUserPage is " + currentColor + "]");
        actions.clickYesButton();
    }


    @Parameters({"emptyUserForTest", "passwordForTest", "fullNameForTest", "emailAddressForTest"})
    @Test
    public void testCreateEmptyUser(String emptyUserForTest, String passwordForTest, String fullNameForTest, String emailAddressForTest) {
        actions.submitFormWithEmptyUser(emptyUserForTest, passwordForTest, fullNameForTest, emailAddressForTest);
        String currentMessage = actions.getMessage();
        Assert.assertTrue(validators.checkErrorMessage("\"\" is prohibited as a full name for security reasons.", currentMessage), "[Error message doesn't appear!" + " current Message] " + currentMessage);
    }


    @Test
    public void testChangeAutoRefreshButtons() {
        String firstTextButton = actions.getTextAutoRefreshButtons();
        actions.clickAutoRefreshButton();
        String secondTextButton = actions.getTextAutoRefreshButtons();
        Assert.assertEquals(firstTextButton, "ENABLE AUTO REFRESH");
        Assert.assertEquals(secondTextButton, "DISABLE AUTO REFRESH");
        Assert.assertFalse(firstTextButton.equals(secondTextButton));
    }
}
