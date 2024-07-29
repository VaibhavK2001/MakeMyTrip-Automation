package util;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class ExcelFileReading {

    public String[][] getData(String Sheet1) throws IOException {

        String path = "C:\\Users\\vaibh\\IdeaProjects\\MakeMyTrip_Automation\\src\\main\\java\\mmt\\testdata\\Book1.xlsx";
        XLUtility xlUtility = new XLUtility(path);

        int totalRows = xlUtility.getRowCount(Sheet1);
        int totalCols = xlUtility.getCellCount(Sheet1,1);

        String data[][] = new String[totalRows][totalCols];

        for (int i = 1; i <= totalRows ; i++) {
            for (int j = 0; j <totalCols ; j++) {
                data[i-1][j]=xlUtility.getCellData(Sheet1,i,j);
            }
        }

        return data;
    }

    @DataProvider(name = "j")
    public String[][] journeys() throws IOException {
        return getData("Sheet1");
    }
}
