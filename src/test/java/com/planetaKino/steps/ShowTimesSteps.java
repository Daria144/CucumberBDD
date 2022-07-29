package com.planetaKino.steps;

import com.planetaKino.pages.BoxPage;
import com.planetaKino.pages.MainPage;
import com.planetaKino.pages.ShowTimesPage;
import com.planetaKino.utils.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class ShowTimesSteps extends BaseClass {

//    BaseClass base;
//
//    public ShowTimesSteps(BaseClass base) {
//        this.base = base;
//    }

    ShowTimesPage showTimesPage=new ShowTimesPage(driver);
    BoxPage boxPage=new BoxPage(driver);
    MainPage mainPage=new MainPage(driver);


    @And("User selects available session and seat")
    public void userSelectsAvailableSessionAndSeat() {
        showTimesPage.selectLastAvailableSession();
        showTimesPage.selectAvailableSeat();
    }

    @And("User adds ticket to cart")
    public void userAddsTicketToCart() {
        showTimesPage.addTicketToCart();
    }

    @Then("User select option to buy as guest")
    public void userSelectOptionToBuyAsGuest() {
        boxPage.acceptGlassesOption();
        boxPage.buyTicketAsGuest();
    }
    

    @And("User filters movies by ([^\"]*), ([^\"]*) and ([^\"]*)$")
    public void usersFiltersMoviesByCityPeriodAndTechnology(String cinema, String period, String tech) {
        mainPage.selectCityByCinema(cinema);
        showTimesPage.selectPeriodByName(period);
        showTimesPage.selectTechByName(tech);
    }

    @And("User (dis)selects session in {string} technology")
    public void userSelectsSessionInTechnology(String tech) {
        showTimesPage.selectTechByName(tech);
        showTimesPage.selectLastAvailableSession();
    }


    @Then("VIP seats are available")
    public void vipSeatsAreAvailableToBeBought() {
        Assert.assertTrue(showTimesPage.linkToVIPIsDisplayed());
    }


    @Then("No VIP seats are displayed")
    public void noVIPSeatsAreDisplayed() {
        Assert.assertFalse(showTimesPage.linkToVIPIsDisplayed());
    }


    @And("User select sessions in a {string}")
    public void userSelectSessionsInA(String period) {
        showTimesPage.selectPeriodByName(period);
    }

    @And("User (dis)selects {string} technology")
    public void userDisselectsTechnology(String tech) {
        showTimesPage.selectTechByName(tech);

    }


    @Then("Only {string} technology is selected")
    public void onlyTechnologyIsSelected(String availableTech) {
        Assert.assertTrue(showTimesPage.techIsSelected(availableTech));
    }
}
