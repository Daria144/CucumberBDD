package com.planetaKino.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.planetaKino.utils.ConfigProperties.getProperty;

public class BaseClass {
    public static WebDriver driver;
    public static WebDriverWait wait;;

    public void launch(){
        System.setProperty(getProperty("webdriver"), getProperty("driverpath"));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    public void closeDriver(){
        driver.quit();
    }

    public static void waitUntilClickable(WebElement element){
        wait=new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void waitUntilDisplayed(WebElement element){
        wait=new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    protected void logMessage(String message) {
        Reporter.log(message, true);
    }

}
