import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelUtils {

    @Test
    public void excelRead() {
        FileInputStream fis;
        XSSFRow row;
        {
            try {
                fis = new FileInputStream("C:\\Users\\rajes\\Documents\\demo.xlsx");
                XSSFWorkbook workbook = new XSSFWorkbook(fis);
                XSSFSheet workSheet = workbook.getSheet("Sheet1");
                for (Row rw : workSheet) {
                    row = (XSSFRow) rw;
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        System.out.println(cell.getStringCellValue());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void readExcel() {
        FileInputStream fis;
        try {
            fis = new FileInputStream("C:\\Users\\rajes\\Documents\\demo.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(0);
            for (int i=1; i<=sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    System.out.println(cell.getStringCellValue());
                }
            }
            FileOutputStream fos;
            fos = new FileOutputStream("C:\\Users\\rajes\\Documents\\demo.xlsx");
            workbook.getSheetAt(1).getRow(2).getCell(1).setCellValue("Hello");
            workbook.write(fos);
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createExcel() throws IOException {
        File file = new File("C:\\Users\\rajes\\Documents\\demo.xlsx");
        file.createNewFile();
        file.deleteOnExit();
    }

    @Test
    public void takeScreenshot() {
        FirefoxDriver driver;
        System.setProperty("webdriver.gecko.driver", "C:\\Driver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.toolsqa.com/automation-practice-table/");
        File scrFile = (driver.getScreenshotAs(OutputType.FILE));

        //FileUtils.copyFile(scrFile, new File("d:\\Selenium\\screenshot2.png"));

    }
}
