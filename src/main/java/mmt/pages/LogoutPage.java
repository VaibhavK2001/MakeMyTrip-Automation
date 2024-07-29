package mmt.pages;

import mmt.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LogoutPage extends Base {

    public LogoutPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//img[@alt='Make My Trip']")
    WebElement homeIcon;

    @FindBy(xpath = "//span[text()='Hi Vaibhav']")
    WebElement account;

    @FindBy(xpath = "//p[contains(text(),'Manage your profile, traveller details, login deta')]")
    WebElement profile;

    @FindBy(xpath = "//li[normalize-space()='Logout']")
    WebElement logout;

    public void logout() throws InterruptedException {
//        actions.moveToElement(account);
        profile.click();
        logout.click();
        Thread.sleep(3000);
    }
}
