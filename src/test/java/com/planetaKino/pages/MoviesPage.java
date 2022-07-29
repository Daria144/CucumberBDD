package com.planetaKino.pages;

import com.planetaKino.utils.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MoviesPage extends BaseClass {

    public MoviesPage(WebDriver driver) {

        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//*[@class='movie-block__link'])[1]")
    private WebElement firstMoviePoster;

    @FindBy(xpath = "//*[@id='film-details']/*[contains(@class,'wishlist')]")
    private WebElement addSelectedMovieToWishlist;

    public void selectFirstMoviePoster(){
        logMessage("[INFO] Selecting first movie poster");
        firstMoviePoster.click();
    }

    public void addSelectedMovieToWishlist(){
        logMessage("[INFO] Adding selected movie to wishlist");
        addSelectedMovieToWishlist.click();
    }
}
