package pages;


import org.testng.Assert;
import org.testng.annotations.Test;
import settings.WebDriverSettings;

public class JenkinsTests extends WebDriverSettings {

    @Test
    public void testJenkins1(){
        JenkinsStartPage jenkinsStartPage = new JenkinsStartPage(driver);
        ManageJenkinsPage manageJenkinsPage = jenkinsStartPage.clickManageJenkinsLink();
        Assert.assertTrue(manageJenkinsPage.elementPresentInManageJenkinsPage(manageUsersText1, tagname1),"[Element " + tagname1 + " with text " + manageUsersText1 + " is absent]");
        Assert.assertTrue(manageJenkinsPage.elementPresentInManageJenkinsPage(manageUsersText2, tagname2),"[Element " + tagname2 + " with text " + manageUsersText2 + " is absent]");
    }


    @Test
    public void testJenkins2(){
        JenkinsStartPage jenkinsStartPage = new JenkinsStartPage(driver);
        ManageJenkinsPage manageJenkinsPage = jenkinsStartPage.clickManageJenkinsLink();
        UsersPage usersPage = manageJenkinsPage.clickManageUsersLink();
        Assert.fail("[Test failed! Test hasn't already completed]");
    }

    @Test
    public void testJenkins3(){
        JenkinsStartPage jenkinsStartPage = new JenkinsStartPage(driver);
        ManageJenkinsPage manageJenkinsPage = jenkinsStartPage.clickManageJenkinsLink();
        UsersPage usersPage = manageJenkinsPage.clickManageUsersLink();
        CreateUserPage createUserPage = usersPage.clickCreateUserLink();
        Assert.assertTrue(createUserPage.isFormPresent(), "[Form with fields of type text and password isn't present]");
        Assert.assertTrue(createUserPage.isFieldsEmpty(), "[All fields in form aren't empty]");
    }

    @Test
    public void testJenkins4() {
        JenkinsStartPage jenkinsStartPage = new JenkinsStartPage(driver);
        ManageJenkinsPage manageJenkinsPage = jenkinsStartPage.clickManageJenkinsLink();
        UsersPage usersPage = manageJenkinsPage.clickManageUsersLink();
        CreateUserPage createUserPage = usersPage.clickCreateUserLink();
        createUserPage.submitFilledForm(userForTest, passwordForTest, fullNameForTest, emailAddressForTest);
        Assert.assertTrue(usersPage.isTextPresent(tagname3, tagname4, userForTest), "Element with text someuser absent");
    }

        @Test
        public void testJenkins5(){
            JenkinsStartPage jenkinsStartPage = new JenkinsStartPage(driver);
            ManageJenkinsPage manageJenkinsPage = jenkinsStartPage.clickManageJenkinsLink();
            UsersPage usersPage = manageJenkinsPage.clickManageUsersLink();
            CreateUserPage createUserPage = usersPage.clickCreateUserLink();
            createUserPage.submitFilledForm(userForTest, passwordForTest, fullNameForTest, emailAddressForTest);
            SomeUserPage someUserPage = usersPage.clickDeleteLink();
            Assert.assertTrue(someUserPage.isTextConfirmationPresent(textConfirmation), "[Text ]" + textConfirmation + "[ isn't present]");
    }

    @Test
    public void testJenkins6(){
        JenkinsStartPage jenkinsStartPage = new JenkinsStartPage(driver);
        ManageJenkinsPage manageJenkinsPage = jenkinsStartPage.clickManageJenkinsLink();
        UsersPage usersPage = manageJenkinsPage.clickManageUsersLink();
        CreateUserPage createUserPage = usersPage.clickCreateUserLink();
        createUserPage.submitFilledForm(userForTest, passwordForTest, fullNameForTest, emailAddressForTest);
        SomeUserPage someUserPage = usersPage.clickDeleteLink();
        someUserPage.clickYesButton();
        Assert.assertFalse(usersPage.isTextPresent(tagname3, tagname4, userForTest), "Element is on the page");
        Assert.assertFalse(usersPage.isLinkPresent(textHrefAttribute), "Link is on the page");
    }

}
