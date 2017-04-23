package com.san.auto;

import com.san.auto.browser.Firefox;
import com.san.auto.entity.Task;
import com.san.auto.enums.TypeOfWork;
import com.san.auto.job.AutoLogWork;
import com.san.auto.job.AutoLogin;
import com.san.auto.job.ExcelReader;
import com.san.auto.util.PropertyUtil;
import com.san.auto.util.SystemUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;


/**
 * Created by nguye on 3/25/2017.
 */
public class Main {

    private List<Task> taskList;
    private List<String> errorTask;
    private List<String> successTask;

    public static void main(String[] args) {
        new Main().run();
    }

    public Main() {
        taskList = new ArrayList<Task>();
        errorTask = new ArrayList<String>();
        successTask = new ArrayList<String>();
    }

    public void run() {
        Properties appProps = PropertyUtil.loadProperties();
        loadAllTask(appProps);
        logTask(appProps);
    }


    private synchronized void logTask(Properties appProps) {
        //Login
        new AutoLogin(appProps).login(Firefox.getWebDriver());

        //Wait page loaded
        SystemUtil.sleep(2000);
        //Log work
        AutoLogWork work = new AutoLogWork(appProps);

        System.out.println("Number of task : " + taskList.size());


        //work.logTask(Firefox.getWebDriver(), new Task("CMELASEDS1-162", new Date(), 1.2, "Test", TypeOfWork.REVIEW));
        for(Task task : taskList) {
            try {
                System.out.print("\nProcess Task : " + task.getKeyId());
                work.logTask(Firefox.getWebDriver(), task);
                System.out.print(" - Finish Task : " + task.getKeyId());
                successTask.add(task.getKeyId());
            } catch (Exception ex) {
                System.out.print(" - Exception - " + ex.getMessage());
                errorTask.add(task.getKeyId());
            }
        }

        System.out.println("Number of task : " + taskList.size());
        System.out.println("Number of success : " + successTask.size());
        System.out.println("Number of error : " + errorTask.size());
        System.out.println("List task error : " + errorTask);

        Firefox.getWebDriver().close();
        Firefox.getWebDriver().quit();
    }

    private  void loadAllTask(Properties appProps) {
        String excelLocaltion = appProps.getProperty("excelFile");
        String [] excelFiles  = excelLocaltion.split(",");

        taskList = new ArrayList<Task>();

        for(String file : excelFiles) {
            taskList.addAll(ExcelReader.loadTask(file));
        }
    }
}
