package com.san.auto.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by nguye on 3/25/2017.
 */
public class Firefox {

    private static WebDriver driver;

    private static WebDriverWait wait;

    public static WebDriver getWebDriver() {
        System.setProperty("webdriver.gecko.driver","./geckodriver.exe");
        if(driver == null) {
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public static WebDriverWait getWebDriverWait() {
        if(driver == null) {
            driver = new FirefoxDriver();
        }
        if(wait == null) {
            wait = new WebDriverWait(driver, 10000);
        }

        return wait;
    }

    public static void wait (String name) {
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.id(name)));
    }
}
