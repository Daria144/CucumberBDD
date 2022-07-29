package com.planetaKino.steps;

import com.planetaKino.pages.MainPage;
import com.planetaKino.pages.enums.Page;
import com.planetaKino.utils.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static com.planetaKino.utils.ConfigProperties.getProperty;

public class MainPageSteps extends BaseClass {

//    BaseClass base;
//
//    public MainPageSteps(BaseClass base) {
//        this.base = base;
//    }

    MainPage mainPage=new MainPage(driver);


    @When("User navigates to {string} page")
    public void userNavigatesToPage(String page) {
        logMessage("[INFO] Navigating to "+page+" page");
        driver.findElement(By.xpath(Page.resolveByName(page))).click();
    }

    @Given("User is on Main Page")
    public void userIsOnMainPage() {
        logMessage("[INFO] Navigating to Main page");
        driver.navigate().to(getProperty("url"));
    }

    @And("User selects {string} cinema")
    public void userSelectsCinema(String cinemaName) {
        logMessage("[INFO] Selecting to "+cinemaName+" cinema");
        mainPage.selectCityByCinema(cinemaName);
    }
}
