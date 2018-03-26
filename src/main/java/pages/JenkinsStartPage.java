package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JenkinsStartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public JenkinsStartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class=\"task\"][4]//a[@class=\"task-link\"]")
    private WebElement manageJenkinsLink;


    public ManageJenkinsPage clickManageJenkinsLink() {
        manageJenkinsLink.click();
        return new ManageJenkinsPage(driver);
    }


}
