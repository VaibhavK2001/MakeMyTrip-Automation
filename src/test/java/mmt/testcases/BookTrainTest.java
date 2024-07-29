package mmt.testcases;

import Listners.TestListner;
import io.qameta.allure.*;
import mmt.base.Base;
import mmt.pages.*;
import org.testng.annotations.*;
import java.io.IOException;

@Listeners(TestListner.class)
public class BookTrainTest extends Base {

    public BookTrainTest() throws IOException {
        super();
    }

    LoginPage loginPage;
    HomePage homePage;
    TrainSearch trainSearch;
    SelectTrain selectTrain;
    SelectTravellerTrain selectTravellerTrain;


    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        loginPage = new LoginPage();
        trainSearch = new TrainSearch();
        selectTrain = new SelectTrain();
        selectTravellerTrain = new SelectTravellerTrain();
        logger.info("Book Train Test Runnig");
    }

    //(dataProvider = "j", dataProviderClass = ExcelFileReading.class)
    @Description("Train booked successfully")
    @Epic("EP01")
    @Feature("Train Booking")
    @Story("Train Booking System case")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void bookTrainTest() throws IOException, InterruptedException {
        homePage = loginPage.login();
        selectTrain = trainSearch.searchTrain();
        selectTravellerTrain = selectTrain.selectTrain();
        selectTravellerTrain.selectTraveller();
    }

//    @AfterMethod
//    public void tearDown() throws InterruptedException {
//        Thread.sleep(5000);
//        driver.navigate().back();
//        driver.close();
//    }

}
