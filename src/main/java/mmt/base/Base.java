package mmt.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Base {

    public static WebDriver driver;
    public static Properties properties;

    public static Logger logger = Logger.getLogger(String.valueOf(Base.class));

    public ExtentReports extent = new ExtentReports();
    public ExtentReporter spark = new ExtentSparkReporter("C:\\Users\\vaibh\\IdeaProjects\\MakeMyTrip_Automation\\test_Output\\ExtentReport.html");

    public Base() throws IOException {

        properties = new Properties();
        FileInputStream ip = new FileInputStream("C:\\Users\\vaibh\\IdeaProjects\\MakeMyTrip_Automation\\src\\main\\java\\mmt\\config\\config.properties");
        properties.load(ip);
    }



    public static void initialization(){

        String browser = properties.getProperty("browser");
        if (browser.equalsIgnoreCase("Chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("user-data-dir=C:/Users/vaibh/AppData/Local/Google/Chrome/User Data");
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        }



        driver.get(properties.getProperty("url"));
    }
}
