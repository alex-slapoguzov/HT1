package com.epam.training.validators;

import com.epam.training.driver.ChromeDriverSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.Collection;


public class Validators {

    private WebDriver driver = ChromeDriverSettings.getDriver();
    private WebDriverWait wait = new WebDriverWait(driver, 30);

    public boolean checkElementPresentWithTagNameAndText(String tagname, String text) {
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

    public boolean checkLinkPresent(String link) {
        boolean result = false;
        if (driver.findElement(By.linkText(link)).isEnabled()) {
            result = true;
        }
        return result;
    }

    public boolean checkTextPresent(String tagname1, String tagname2, String text) {
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

    public boolean checkLinkWithHrefPresent(String text) {
        Collection<WebElement> tags = driver.findElements(By.xpath("//table[@class=\"sortable pane bigtable\"]"));
        if (tags.isEmpty()) {
            return false;
        }
        boolean result = false;
        for (WebElement element : tags) {
            if (element.findElement(By.tagName("a")).getAttribute("href").equalsIgnoreCase(text)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean checkFormPresent() {
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@id=\"main-panel\"]//form"), 1));
        WebElement form = driver.findElement(By.xpath("//div[@id=\"main-panel\"]//form"));

        boolean form_found = false;

        if ((form.findElement(By.name("username")).getAttribute("type").equalsIgnoreCase("text")) &&
                (form.findElement(By.name("password1")).getAttribute("type").equalsIgnoreCase("password")) &&
                (form.findElement(By.name("password2")).getAttribute("type").equalsIgnoreCase("password")) &&
                (form.findElement(By.name("fullname")).getAttribute("type").equalsIgnoreCase("text")) &&
                (form.findElement(By.name("email")).getAttribute("type").equalsIgnoreCase("text"))) {
            form_found = true;
        }
        return form_found;

    }

    public boolean checkFieldsInFormEmpty() {
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@id=\"main-panel\"]//form"), 1));
        WebElement form = driver.findElement(By.xpath("//div[@id=\"main-panel\"]//form"));

        boolean form_found = false;

        if ((form.findElement(By.name("username")).getText().equals("")) &&
                (form.findElement(By.name("password1")).getText().equals("")) &&
                (form.findElement(By.name("password2")).getText().equals("")) &&
                (form.findElement(By.name("fullname")).getText().equals("")) &&
                (form.findElement(By.name("email")).getText().equals(""))) {
            form_found = true;
        }
        return form_found;
    }

    public boolean checkTextConfirmation(String text, String textConfirmation) {
        boolean result = false;
        if (text.contains(textConfirmation)) {
            result = true;
        }
        return result;
    }

    public boolean checkErrorMessage(String message, String currentMessage) {
        boolean result = false;
        if (message.equals(currentMessage)) {
            result = true;
        }
        return result;
    }

    public boolean checkButtonColor(String currentColor, String color) {
        if (color.equals(currentColor)) {
            return true;
        } else {
            return false;
        }
    }

}
