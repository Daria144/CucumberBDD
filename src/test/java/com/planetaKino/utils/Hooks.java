package com.planetaKino.utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends BaseClass{


    @Before
    public void browserSetUp(){
        launch();
    }

    @After
    public void teardown(Scenario scenario) {
        closeDriver();
    }
}
