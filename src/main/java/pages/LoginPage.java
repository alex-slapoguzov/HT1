package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "j_username")
    private WebElement loginField;

    @FindBy(name = "j_password")
    private WebElement passwordField;

    @FindBy(id = "yui-gen1-button")
    private WebElement inputButton;


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
}
