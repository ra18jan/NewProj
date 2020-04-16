import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SampleTest extends Const implements IData, IFunc {

    WebDriver driver;
    IFunc func;

    @Test(priority = 0)
    public void test() {
        System.setProperty("webdriver.gecko.driver", "C:\\Driver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.toolsqa.com/automation-practice-table/");
        List<WebElement> tableRow = driver.findElements(By.tagName("tr"));
        System.out.println(tableRow.size());
        for (WebElement element : tableRow) {
            List<WebElement> data = element.findElements(By.xpath("//following-sibling::td"));
            for (WebElement datum : data) {
                System.out.println(datum.getText());
            }
        }
        driver.quit();
    }

    //@AfterMethod
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void getData() {
        int[] arr = {1, 4, 7, 5, 6, 4, 1, 9};

        /*LinkedHashSet d = new LinkedHashSet();
        for (int x: arr){
            d.add(x);
        }
       Arrays.sort(d.toArray());
        System.out.println(d.toString());*/

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    arr = ArrayUtils.remove(arr, j);
                }
            }
        }
        Integer[] arr2 = new Integer[0];
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
            arr2 = ArrayUtils.add(arr2, arr[i]);
        }
        System.out.println("Reverse array " + Arrays.toString(arr2));
        //Arrays.sort(arr, Collections.reverseOrder());
//        System.out.println("Array after removing elements ::"+Arrays.toString(arr));
    }


    @Test
    public void reverseString(String te) {
        String reverseStr = "";
        int len = te.length();
        for (int i = len - 1; i >= 0; i--) {
            reverseStr = reverseStr + te.charAt(i);
        }
        System.out.println(reverseStr);
    }

    @Test
    public void reverseNum() {
        int num = 1234, reversed = 0;

        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }

        System.out.println("Reversed Number: " + reversed);
    }

    @Test
    public void testMe() {
        String stringToSearch = "abcd1234";
        Pattern p = Pattern.compile("[a-z]+");   // the pattern to search for
        Matcher m = p.matcher(stringToSearch);
        // if we find a match, get the group
        if (m.find()) {
            // we're only looking for one group, so get it
            String theGroup = m.group();
            //stringToSearch = stringToSearch.split(theGroup)[0];
            // print the group out for verification
            System.out.format("'%s'\n", theGroup);
        } else {
            System.out.println("No match");
        }
    }

    /**
     * Maximum of a array
     */
    @Test
    public void testMax() {
        Integer[] arr = {1, 2, 3, 4, 5, 65, 76, 5};
        int max = arr[0];
        for (int x : arr) {
            if (max < x) {
                max = x;
            }
        }

        System.out.println("Max is " + max);
    }

    @Test
    public void dd() {
        Object[] arr = {5.2, 3, 4};
        Integer[] arr2 = new Integer[0];

        for (Object x : arr) {
            if (x.getClass().toString().contains("int")) {
                ArrayUtils.add(arr2, x);
            }
        }
        System.out.println(arr2.length);
    }
}
