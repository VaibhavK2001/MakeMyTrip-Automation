package mmt.pages;

import mmt.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static mmt.base.Base.driver;

public class SelectTrain extends Base {

    public SelectTrain() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='flex align-center justify-space-between']")
    WebElement trainCoach;

    @FindBy(xpath = "//div[text()='OK, GO AHEAD']")
    WebElement goAhead;

    public SelectTravellerTrain selectTrain() throws IOException {
        trainCoach.click();
        goAhead.click();
        return new SelectTravellerTrain();
    }
}
