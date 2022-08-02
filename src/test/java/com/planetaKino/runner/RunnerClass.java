package com.planetaKino.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/movies.feature",
        glue = {"com/planetaKino/steps","com/planetaKino/utils"},
        plugin = {"pretty","html:target/cucumber-reports"},
        monochrome = true)
public class RunnerClass extends AbstractTestNGCucumberTests {
}
