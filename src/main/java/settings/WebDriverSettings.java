package settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import java.util.concurrent.TimeUnit;

public class WebDriverSettings {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String userForLogIn = "admin";
    protected String passwordForLogIn = "admin";
    protected String base_url = "http://localhost:8081/";
    LoginPage loginPage;
    StringBuffer verificationErrors = new StringBuffer();

    protected String userForTest = "someuser";
    protected String passwordForTest = "somepassword";
    protected String fullNameForTest = "Some Full Name";
    protected String emailAddressForTest = "some@addr.dom";
    protected String textConfirmation = "Are you sure about deleting the user from Jenkins?";
    protected String manageUsersText1 = "Manage Users";
    protected String manageUsersText2 = "Create/delete/modify users that can log in to this Jenkins";
    protected String tagname1 ="dt";
    protected String tagname2 ="dd";
    protected String tagname3 ="tr";
    protected String tagname4 ="td";
    protected String textHrefAttribute = "user/someuser/delete";


    @BeforeMethod
    public void setUp() {

        // System.setProperty("webdriver.chromedriver", "C:\\javka");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=en-US");
        driver = new ChromeDriver(chromeOptions);
        driver.get(base_url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        loginPage.submitFilledForm(userForLogIn, passwordForLogIn);

    }

        /*   @AfterMethod
        public void setAfter() {
            driver.quit();

       *//* String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            Assert.fail(verificationErrorString);
        }*//*
    }*/

   /* @BeforeMethod
    public void setUpBeforeMethod(){

        driver.get(base_url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        loginPage.submitFilledForm(user, password);

    }*/
}
