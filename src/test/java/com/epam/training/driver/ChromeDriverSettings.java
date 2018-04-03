package com.epam.training.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ChromeDriverSettings {

    private static WebDriver driver;
    private static final String WEBDRIVER_CHROMEDRIVER = "webdriver.chromedriver";
    private static final String CHROMEDRIVER_PATH = ".\\chromedriver\\chromedriver.exe";


    public static WebDriver getDriver() {
        if (null == driver) {
            System.setProperty(WEBDRIVER_CHROMEDRIVER, CHROMEDRIVER_PATH);
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--lang=en-US");
            driver = new ChromeDriver(chromeOptions);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }

        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
