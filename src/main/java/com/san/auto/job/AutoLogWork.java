package com.san.auto.job;

import com.san.auto.browser.Firefox;
import com.san.auto.entity.Task;
import com.san.auto.util.DateUtil;
import com.san.auto.util.SystemUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Properties;

/**
 * Created by nguye on 3/25/2017.
 */
public class AutoLogWork {

    private Properties applicationProperties;

    public AutoLogWork(Properties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    public void logTask(WebDriver driver, Task task) {

        //navigate to Task with id
        navigateTask(driver, task);

        //wait for page be loaded
        SystemUtil.sleep(2000);

        //open log work pop up
        openLogWorkPopUp(driver);

        //wait pop up
        SystemUtil.sleep(2000);

        // start log work
        logwork(driver, task);

        SystemUtil.sleep(8000);
    }


    private void logwork(WebDriver driver, Task task) {
        String dateString = DateUtil.convertDateString(task.getStartdate());

        /*Require to run to error in time to by pass the calendar pop up*/
        Firefox.wait("datefield-popup");
        WebElement element = driver.findElement(By.id("datefield-popup"));
        element.clear();
        element.sendKeys(dateString);
        Firefox.wait("issue-add-button");
        element = driver.findElement(By.id("issue-add-button"));
        element.click();
        SystemUtil.sleep(1000);

        /*Start fill the form*/
        Firefox.wait("time-popup");
        element = driver.findElement(By.id("time-popup"));
        element.clear();
        element.sendKeys(String.valueOf(task.getTime()));

        // Always set remaining estimate to 0
        Firefox.wait("remainingEstimate-popup");
        element = driver.findElement(By.id("remainingEstimate-popup"));
        element.clear();
        element.sendKeys("0");

        Firefox.wait("comment-popup");
        element = driver.findElement(By.id("comment-popup"));
        element.clear();
        element.sendKeys(task.getDescription());

        Firefox.wait("popup_TypeofWork_");
        Select typeOfWork = new Select((driver.findElement(By.id("popup_TypeofWork_"))));
        typeOfWork.selectByVisibleText(task.getTypeOfWork().getValue());

        Firefox.wait("datefield-popup");
        element = driver.findElement(By.id("datefield-popup"));
        element.clear();
        element.sendKeys(dateString);

        Firefox.wait("issue-add-button");
        element = driver.findElement(By.id("issue-add-button"));
        element.click();
    }

    private void openLogWorkPopUp(WebDriver driver) {
        Actions action = new Actions(driver);
        action.sendKeys(String.valueOf("\u0077")).perform();
    }

    private void navigateTask(WebDriver driver, Task task) {
        driver.get(applicationProperties.getProperty("fiurl") + "/jira/browse/" + task.getKeyId());
    }


}
