import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class DataDrivenTest {

    @DataProvider(name = "testExample")
    public Object[][] ExcelDriven(){

        String cwd = System.getProperty("user.dir");
        String filePath = cwd + File.separator + "src/test/resources/example.xlsx";

        Object[][] arrayObject = getExcelData(filePath, "Sheet1");
        return arrayObject;

    }

    @Test(dataProvider = "testExample")
    public void test1(String userName, String password){

        System.out.print(userName);
        System.out.print("-->");
        System.out.print(password);
        System.out.println();

    }

    public String[][] getExcelData(String fileName, String sheet){

        String[][] arrayExcelData = null;

        try {
            FileInputStream fs = new FileInputStream(fileName);
            Workbook wb = new XSSFWorkbook(fs);
            Sheet dataSheet = wb.getSheet(sheet);

            int rowTotalNum = dataSheet.getLastRowNum() +1;
            int columns = dataSheet.getRow(0).getPhysicalNumberOfCells();

            arrayExcelData=new String[rowTotalNum-1][columns];

            Cell cell = null;
            for(int i=1; i< rowTotalNum; i++){

                for(int j=0; j< columns; j++){
                    cell = dataSheet.getRow(i).getCell(j);
                    arrayExcelData[i-1][j] = cell.getStringCellValue();
                }
            }

            fs.close();
            //HashMap<String, String>[][] map = new HashMap[rowTotalNum-1][1];


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return arrayExcelData;

    }
}
