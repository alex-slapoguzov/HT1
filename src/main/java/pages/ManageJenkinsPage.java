package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collection;


public class ManageJenkinsPage {
    private WebDriver driver;
    private WebDriverWait wait;


    public ManageJenkinsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td[@style=\"vertical-align:middle\"]//a[@href=\"securityRealm/\"]")
    private WebElement manageUsersLink;

    public UsersPage clickManageUsersLink() {
        manageUsersLink.click();
        return new UsersPage(driver);
    }


    public boolean elementPresentInManageJenkinsPage(String tagname, String text) {
        Collection<WebElement> tags = driver.findElements(By.tagName(tagname));
        if (tags.isEmpty()) {
            return false;
        }
        boolean result = false;
        for (WebElement element : tags) {
            if (element.getText().equals(text)) {
                result = true;
                break;
            }
        }
        return result;
    }


}
