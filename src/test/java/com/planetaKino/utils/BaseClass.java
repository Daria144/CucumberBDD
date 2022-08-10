package com.planetaKino.utils;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.planetaKino.utils.ConfigProperties.getProperty;

public class BaseClass {
    public static WebDriver driver;
    public static WebDriverWait wait;;
    private ChromeOptions options;

    public void launch(){
        if(getProperty("server").contains("local")) {
            System.setProperty(getProperty("webdriver"), getProperty("driverpath"));
            options = new ChromeOptions();
            options.addArguments("--window-size=1920x1080");
            driver = new ChromeDriver(options.addArguments("--headless"));
        }
        else if(getProperty("server").contains("remote")){
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setBrowserName("chrome");
            dc.setPlatform(Platform.MAC);
            try {
                driver=new RemoteWebDriver(new URL(getProperty("hubURL")),dc);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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
