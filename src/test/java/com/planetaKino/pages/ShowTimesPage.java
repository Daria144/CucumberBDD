package com.planetaKino.pages;

import com.planetaKino.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShowTimesPage extends BaseClass {

    public ShowTimesPage(WebDriver driver) {

        PageFactory.initElements(driver,this);
    }


    @FindAll(@FindBy(xpath = "//*[@class='chips'][not(@disabled)]"))
    private List<WebElement> sessions;

    @FindAll(@FindBy( css = "[class='hall__seat-number']"))
    private List<WebElement> selectedSeat;

    @FindBy(xpath = "//*[@class='content__left-block']//*[@class='add-to-cart']")
    private WebElement addToCartButton;

    @FindAll(@FindBy(xpath = "//section[contains(@class,'date')]//*[@class='mat-radio-container']"))
    private List<WebElement> dateFilterButtons;

    @FindAll(@FindBy(css = "[class='hall-scheme__popup-button']"))
    private List<WebElement> linkToVIPInfo;



    public void selectLastAvailableSession(){
        logMessage("[INFO] Selecting last available session");
        sessions.get(sessions.size()-1).click();
    }

    public void selectAvailableSeat(){
        List<WebElement> seats=driver.findElements(By.cssSelector("[class='hall__seat']"));
        for (WebElement seat : seats) {
            logMessage("[INFO] Selecting seat");
            seat.click();
            if(selectedSeat.size()>0){
                logMessage("[INFO] Seat is selected");
                break;
            }
        }
    }


    public void addTicketToCart(){
        addToCartButton.click();
    }

    public void selectPeriodByName(String period){
        logMessage("[INFO] Selecting period");
        switch (period.toLowerCase().trim()){
            case "today": {
                dateFilterButtons.get(0).click();
                break;
            }
            case "tomorrow":{
                dateFilterButtons.get(1).click();
                break;
            }
            case "week":
                dateFilterButtons.get(2).click();
                break;
            default:
                dateFilterButtons.get(3).click();
                break;

        }
    }

    public void selectTechByName(String tech) {
        WebElement technology=driver.findElement(By.xpath("//input[contains(@value,\""
                +tech+"\")]/ancestor::div[contains(@class,'mat-checkbox')]"));
        waitUntilClickable(technology);
        logMessage("[INFO] Selecting technology");
        technology.click();
    }

    public boolean linkToVIPIsDisplayed(){
        if(linkToVIPInfo.size()>0){
            logMessage("[INFO] Link to VIP is displayed");
            return true;
        }
        else {
            logMessage("[INFO] Link to VIP is NOT displayed");
            return false;
        }
    }


    public boolean techIsSelected(String tech) {
        WebElement technology=driver.findElement(By.xpath("//input[contains(@value,\""
                +tech+"\")]"));
        return technology.getAttribute("aria-checked").contains("true");
    }
}


