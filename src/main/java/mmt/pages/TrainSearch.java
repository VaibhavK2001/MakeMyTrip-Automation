package mmt.pages;

import mmt.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static mmt.base.Base.driver;

public class TrainSearch extends Base {

    public TrainSearch() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//li[@data-cy=\"menu_Trains\"]")
    WebElement train;

    @FindBy(xpath = "//input[@id=\"fromCity\"]")
    WebElement fromCity;

    @FindBy(xpath = "//input[@aria-autocomplete=\"list\"]")
    WebElement fromCityData;

    @FindBy(xpath = "//input[@placeholder='To']")
    WebElement toCityData;

    @FindBy(xpath = "//div[contains(text(),'2024')]")
    WebElement month;

    @FindBy(xpath = "//span[@aria-label=\"Next Month\"]")
    WebElement nextMonth;

    @FindBy(xpath = "//span[text()='Class']")
    WebElement classSelect;

    @FindBy(xpath = "//li[text()='All Class']")
    WebElement allClass;

    @FindBy(xpath = "//a[text()='Search']")
    WebElement search;

    @FindBy(xpath = "//div[contains(@aria-label,'Aug 15')]")
    WebElement day;

    @FindBy(xpath = "//span[text()='Pune']")
    WebElement to;

    public SelectTrain searchTrain() throws IOException {
        train.click();
        fromCity.click();
        fromCityData.sendKeys("Mumbai");
        fromCityData.sendKeys(Keys.DOWN);
        fromCityData.sendKeys(Keys.ENTER);
        toCityData.sendKeys("Pune");
        to.click();

        int count = 0;
        while(true){
            if (month.getText().equalsIgnoreCase("August 2024")){
                break;
            }
            if (count == 3){
                if(driver.findElement(By.xpath("//div[text()='September 2024']")).getText().equalsIgnoreCase("September 2024")){
                    break;
                }
            }
            nextMonth.click();
            count++;
        }

        day.click();
        classSelect.click();
        allClass.click();
        search.click();

        return new SelectTrain();

    }


}
