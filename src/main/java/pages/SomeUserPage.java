package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SomeUserPage {

    private WebDriver driver;
    private WebDriverWait wait;


    public SomeUserPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

   @FindBy(id = "yui-gen2-button")
    private WebElement yesButton;

    @FindBy(xpath = "//form[@name=\"delete\"]")
    private WebElement formWithText;

    public UsersPage clickYesButton(){
        yesButton.click();
        return new UsersPage(driver);
    }

    public boolean isTextConfirmationPresent(String text){
        boolean result = false;
        if (formWithText.getText().contains(text)){
            result = true;
        }
        return result;
    }
}
