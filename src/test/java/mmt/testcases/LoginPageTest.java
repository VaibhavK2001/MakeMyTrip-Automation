package mmt.testcases;

import Listners.TestListner;
import mmt.base.Base;
import mmt.pages.HomePage;
import mmt.pages.LoginPage;
import mmt.pages.LogoutPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;


public class LoginPageTest extends Base {

    LoginPage loginPage;
    LogoutPage logoutPage;

    public Actions actions = new Actions(driver);

    public LoginPageTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        loginPage = new LoginPage();
        logoutPage = new LogoutPage();
    }

    @Test
    public void loginPageUrlTest(){
        String title = loginPage.validateTitle();
        Assert.assertEquals(title,"MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday");
    }

    @Test
    public void loginTest() throws IOException, InterruptedException {
        HomePage homePage = loginPage.login();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        logoutPage.logout();
        Thread.sleep(5000);
        driver.navigate().back();
        driver.close();
    }

}
