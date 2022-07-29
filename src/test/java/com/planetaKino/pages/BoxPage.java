package com.planetaKino.pages;

import com.planetaKino.utils.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BoxPage extends BaseClass {

    public BoxPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    @FindBy(css = "[class='box']>button[class='btn-gest']")
    private WebElement buyAsGuestOption;

    @FindAll(@FindBy(xpath = "//a[contains(@href,'3d.planetakino')]"))
    private List<WebElement> linkToGlassesInfo;

    @FindAll(@FindBy(css = "[class='box']>button"))
    private List<WebElement> optionsInBox;

    @FindBy(css = "[class='btn-register']")
    private WebElement registerButton;


    public void acceptGlassesOption(){
        if(linkToGlassesInfo.size()>0){
            logMessage("[INFO] Accepting glasses option");
            optionsInBox.get(0).click();
        }
    }

    public void buyTicketAsGuest(){
        logMessage("[INFO] Buying ticket as guest");
        buyAsGuestOption.click();
    }

    public void selectRegisterOption(){
        registerButton.click();
    }


}
