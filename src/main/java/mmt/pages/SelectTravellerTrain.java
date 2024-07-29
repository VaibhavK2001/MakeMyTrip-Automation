package mmt.pages;

import mmt.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SelectTravellerTrain extends Base {

    public SelectTravellerTrain() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//p[text()='Pay fees on cancellation']")
    WebElement cancellation;

    @FindBy(xpath = "//span[text()='Add Traveller']")
    WebElement addTraveller;

    @FindBy(xpath = "//input[@name='name']")
    WebElement name;

    @FindBy(xpath = "//input[@name='age']")
    WebElement age;

    @FindBy(xpath = "//div[@class=\"selectedQuotaContainer noSelection makeRelative\"]")
    WebElement genderDropdown;

    @FindBy(xpath = "//span[text()='Male']")
    WebElement male;

    @FindBy(xpath = "//button[text()='Add']")
    WebElement addButton;

    @FindBy(xpath = "//input[@placeholder='Enter IRCTC username']")
    WebElement irctc;

    @FindBy(xpath = "//input[@id='IRCTCUserName']")
    WebElement irctcUsername;

    @FindBy(xpath = "//span[text()='Submit']")
    WebElement sumbit;

    @FindBy(xpath = "//input[@id='contactEmail']")
    WebElement contactEmail;

    @FindBy(xpath = "//input[@id='mobileNumber']")
    WebElement contactMobile;

    @FindBy(xpath = "//p[text()='Confirm and save billing details to your profile']")
    WebElement confirmBill;

    @FindBy(xpath = "//span[text()='Pay & Book Now']")
    WebElement payBook;

    public void selectTraveller() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        cancellation.click();
        addTraveller.click();
        name.sendKeys("Vaibhav Kumbhar");
        age.sendKeys("23");
        genderDropdown.click();
        male.click();
        addButton.click();
//        contactEmail.click();
//        contactEmail.sendKeys("vaibhav@gmail.com");
        contactMobile.sendKeys("9876543210");
        Thread.sleep(3000);
        payBook.click();
    }

}
