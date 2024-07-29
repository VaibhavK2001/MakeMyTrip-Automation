package mmt.pages;

import mmt.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class LoginPage extends Base {

    public LoginPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//p[@data-cy=\"LoginHeaderText\"]")
    WebElement loginButton;

    @FindBy(xpath = "//div[@class='nsm7Bb-HzV7m-LgbsSe-bN97Pc-sM5MNb ']")
    WebElement googleIcon;

    @FindBy(xpath = "//div[@class=\"fFW7wc-ibnC6b-r4m2rf\"]")
    WebElement googleAccount;

    @FindBy(xpath = "//span[@data-cy=\"closeModal\"]")
    WebElement closeButton;

    public String validateTitle(){
        return driver.getTitle();
    }

    public HomePage login() throws InterruptedException, IOException {
        Thread.sleep(2000);
        closeButton.click();
        loginButton.click();
        googleIcon.click();
        Thread.sleep(2000);
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                driver.findElement(By.xpath("//div[@class=\"fFW7wc-ibnC6b-r4m2rf\"]")).click();
            }
            Thread.sleep(10000);
            driver.switchTo().window(mainWindowHandle);
        }

        return new HomePage();
    }

}
