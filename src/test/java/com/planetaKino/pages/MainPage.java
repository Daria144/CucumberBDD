package com.planetaKino.pages;

import com.planetaKino.utils.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage extends BaseClass {

    public MainPage(WebDriver driver) {

        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "[data-toggle='citylist']")
    private WebElement cityList;

    @FindAll(@FindBy(css = "#citylist span"))
    private List<WebElement> cityListItem;



    public void selectCityByCinema(String cinemaName) {
        logMessage("[INFO] Expanding cinema list");
        cityList.click();
        for (WebElement cinema : cityListItem) {
            if(cinema.getText().contains(cinemaName)){
                logMessage("[INFO] Selecting "+cinemaName+" from list");
                cinema.click();
                break;
            }
        }
    }



}
