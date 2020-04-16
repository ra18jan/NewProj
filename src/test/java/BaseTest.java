import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver driver;
    public List<String> ls;
    private HashMap<String, String> userDetails = new HashMap<>();

    @Test
    public void loginFromExcel(){
        readExcel();
        String userId = ls.get(0);
        String password = ls.get(1);

        LoginPage loginPage = new LoginPage();
        loginPage.setUserId(userId);
        loginPage.setPassword(password);
//        driver.findElement(By.id("username")).sendKeys(ls.get(0));
//        driver.findElement(By.id("password")).sendKeys(ls.get(1));
        driver.findElement(By.linkText("Sign in")).click();
    }

    @Test
    @Parameters({"username","password"})
    public void loginFromXml(String username, String password){
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"app__container\"]/main/div/form/div[3]/button")).click();
    }

    @Test(dataProvider = "xy")
    public void loginUsingDP(String username, String password){
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"app__container\"]/main/div/form/div[3]/button")).click();
    }

    public void readExcel(){
        File file = new File("C:\\Users\\rajes\\Documents\\SampleFile.xlsx");
        try {
            FileInputStream fis = new FileInputStream(file);
            try {
                XSSFWorkbook wb= new XSSFWorkbook(fis);
                XSSFSheet sh = wb.getSheetAt(0);
                Row rw = sh.getRow(1);
                for (int i=0;i<rw.getLastCellNum();i++) {
                    ls.add(rw.getCell(i).toString());
                    System.out.println(rw.getCell(i).toString());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @DataProvider(name = "xy")
    public static Object[][] data(){
        return new Object[][]{{"rajmek96@gmail.com","l12"}};
    }

    @BeforeMethod
    public void initApp(){
        System.setProperty("webdriver.gecko.driver", "C:\\Driver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //driver.get("https://www.linkedin.com/login");
    }

    @AfterMethod
    public void closeSession(){
        driver.quit();
    }
}
