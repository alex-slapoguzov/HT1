package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collection;


public class UsersPage {

    private WebDriver driver;
    private WebDriverWait wait;


    public UsersPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class=\"task\"][3]//a[@class=\"task-link\"]")
    private WebElement createUserLink;

    @FindBy(xpath = "//a[@href=\"user/someuser/delete\"]")
    private WebElement deleteLink;


    public CreateUserPage clickCreateUserLink() {
        createUserLink.click();
        return new CreateUserPage(driver);
    }

    public SomeUserPage clickDeleteLink(){
        deleteLink.click();
        return new SomeUserPage(driver);
    }

     public boolean isTextPresent(String tagname1, String tagname2, String text){
         Collection<WebElement> tags = driver.findElements(By.tagName(tagname1));
         if (tags.isEmpty()) {
             return false;
         }
         boolean result = false;
         for (WebElement element : tags) {
             Collection<WebElement> tags2 = element.findElements(By.tagName(tagname2));
             if (tags.isEmpty()) {
                 return false;
             }
             for (WebElement element2 : tags2) {

                 if (element2.getText().equals(text)) {
                     result = true;
                     break;
                 }
             }
         }
         return result;
     }

     public boolean isLinkPresent(String text){
         boolean result = false;
         if (driver.findElement(By.linkText(text)).isEnabled()){
             driver.findElement(By.linkText(text)).getAttribute("href").equalsIgnoreCase(text);
             result = true;
         }
         return result;
       /*  Collection<WebElement> tags = driver.findElements(By.tagName("a"));
         if (tags.isEmpty()) {
             return false;
         }
         boolean result = false;
         for (WebElement element : tags) {
             if (element.getAttribute("href").equalsIgnoreCase(text)) {
                 result = true;
                 break;
             }
         }
         return result;*/
     }


     }




   /* public boolean isPresentDeleteLink(){
        driver.findElement(By.xpath("href="user/someuser/delete""))
    }*/



