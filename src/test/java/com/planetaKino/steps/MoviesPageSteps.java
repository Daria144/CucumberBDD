package com.planetaKino.steps;

import com.planetaKino.pages.MoviesPage;
import com.planetaKino.utils.BaseClass;
import io.cucumber.java.en.And;

public class MoviesPageSteps extends BaseClass {

    MoviesPage moviesPage=new MoviesPage(driver);


    @And("User selects desirable movie")
    public void userSelectsDesirableMovie() {
        moviesPage.selectFirstMoviePoster();
    }

    @And("User adds it to wishlist")
    public void userAddsItToWishlist() {
        moviesPage.addSelectedMovieToWishlist();
    }


}
