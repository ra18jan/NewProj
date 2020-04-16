import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Const {

    private String va;

    public String getValue(){
        return va;
    }

    public void staticTesting(){
        //new SampleTest().testIt("Hello00");
    }

    public static void prog(){
        new Const().staticTesting();
    }

    @Test
    public void addList(){
        List ls = new LinkedList();
        ls.add(5);
        ls.add(4);
        ls.add(3);
        System.out.println(ls.toString());

        Map hk = new HashMap();
        hk.put(7,9);
        hk.put("fg","ll");
        Map<String, String> dr = new HashMap<>();
        dr.put("hi","hello");

        WebDriver driver = null;
        new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(12)).pollingEvery(Duration.ofSeconds(4)).
                until((WebDriver o) -> o.findElement(By.name("dd")).getText().equals("f"));

    }


    public boolean isPrime(int n){
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void checkPrime(){
        int n = 5;
        if(isPrime(n)){
            System.out.println("Prime number");
            System.out.println(Math.sqrt(n));
        } else {
            System.out.println("Not a prime number");
            System.out.println(Math.sqrt(n));
        }

    }
}
