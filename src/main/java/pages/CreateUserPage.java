package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collection;
import java.util.Iterator;


public class CreateUserPage {

    private WebDriver driver;
    private WebDriverWait wait;


    public CreateUserPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    private WebElement usernameInForm;

    @FindBy(name = "password1")
    private WebElement passwordInForm;

    @FindBy(name = "password2")
    private WebElement confirmPasswordInForm;

    @FindBy(name = "fullname")
    private WebElement fullNameInForm;

    @FindBy(name = "email")
    private WebElement emailAddressInForm;

    @FindBy(id = "yui-gen2-button")
    private WebElement createUserButton;



    public boolean isFormPresent() {
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//body//div[@id=\"main-panel\"]/form"), 1));
        Collection<WebElement> forms = driver.findElements(By.xpath("//body//div[@id=\"main-panel\"]/form"));
        if (forms.isEmpty()) {
            return false;
        }
        Iterator<WebElement> i = forms.iterator();
        boolean form_found = false;
        WebElement form = null;
        while (i.hasNext()) {
            form = i.next();
            if ((form.findElement(By.name("username")).getAttribute("type").equalsIgnoreCase("text")) &&
                    (form.findElement(By.name("password1")).getAttribute("type").equalsIgnoreCase("password")) &&
                    (form.findElement(By.name("password2")).getAttribute("type").equalsIgnoreCase("password")) &&
                    (form.findElement(By.name("fullname")).getAttribute("type").equalsIgnoreCase("text")) &&
                    (form.findElement(By.name("email")).getAttribute("type").equalsIgnoreCase("text"))) {
                form_found = true;
                break;
            }
        }
        return form_found;
    }

    public boolean isFieldsEmpty() {
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//body/div/div/form"), 1));
        Collection<WebElement> forms = driver.findElements(By.xpath("//body/div/div/form"));
        if (forms.isEmpty()) {
            return false;
        }
        Iterator<WebElement> i = forms.iterator();
        boolean form_found = false;
        WebElement form = null;
        while (i.hasNext()) {
            form = i.next();
            if ((form.findElement(By.name("username")).getText().equals("")) &&
                    (form.findElement(By.name("password1")).getText().equals("")) &&
                    (form.findElement(By.name("password2")).getText().equals("")) &&
                    (form.findElement(By.name("fullname")).getText().equals("")) &&
                    (form.findElement(By.name("email")).getText().equals(""))) {
                form_found = true;
                break;
            }
        }
        return form_found;
    }

    public void typeUsername(String name){
        usernameInForm.clear();
        usernameInForm.sendKeys(name);
    }

    public void typePassword(String password){
        passwordInForm.clear();
        passwordInForm.sendKeys(password);
    }

    public void typeConfirmPassword(String password){
        confirmPasswordInForm.clear();
        confirmPasswordInForm.sendKeys(password);
    }

    public void typeFullName(String fullName){
        fullNameInForm.clear();
        fullNameInForm.sendKeys(fullName);
    }

    public void typeEmailAddress(String email){
        emailAddressInForm.clear();
        emailAddressInForm.sendKeys(email);
    }

    public UsersPage clickCreateUserButton(){
        createUserButton.click();
        return new UsersPage(driver);
    }

    public UsersPage submitFilledForm(String name, String password, String fullName, String email){
        typeUsername(name);
        typePassword(password);
        typeConfirmPassword(password);
        typeFullName(fullName);
        typeEmailAddress(email);
       return clickCreateUserButton();
    }

}
