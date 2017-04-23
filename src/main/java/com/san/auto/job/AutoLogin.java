package com.san.auto.job;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

/**
 * Created by nguye on 3/25/2017.
 */
public class AutoLogin {
    private Properties applicationProperties;

    public AutoLogin(Properties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    public void login(WebDriver driver) {
        driver.get(applicationProperties.getProperty("fiurl"));

        driver.findElement(By.id("login-form-username")).sendKeys(applicationProperties.getProperty("username"));
        driver.findElement(By.id("login-form-password")).sendKeys(applicationProperties.getProperty("password"));
        driver.findElement(By.id("login-form-password")).sendKeys(Keys.ENTER);
    }

    public void logout(WebDriver driver) {

    }
}
