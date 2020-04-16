import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Numbers {

    /**
     * get square root of a number
     */
    @Test
    public void squareRoot() {
        int num = 16;
        double sr = num / 2;
        double temp;
        do {
            temp = sr;
            sr = (temp + (num / temp)) / 2;
        } while ((temp - sr) != 0);
        System.out.println("Square root is " + sr);
    }

    /**
     * find number words in string
     */
    @Test
    public void findWords() {
        String str = "jh ld jh kff io kff";
        String[] splitString = str.split(" ");
        Map<String, Integer> mp = new HashMap<>();
        for (String x : splitString) {
            if (mp.containsKey(x)) {
                mp.put(x, mp.get(x) + 1);
            } else {
                mp.put(x, 1);
            }
        }
        System.out.println(mp);
        // js.executeScript("window.scrollBy(0,1000)");
    }

    /**
     * Second largest number
     */
    @Test
    public void secondLargestNumber() {
        int[] arr = {1, 2, 5, 3, 4, 7};
        int l = arr[0];
        int sl = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > l) {
                sl = l;
                l = arr[i];
            } else if (arr[i] > sl && arr[i] != l) {
                sl = arr[i];
            }
        }
        System.out.println(sl);
    }

    /**
     * Remove white spaces
     */
    @Test
    public void removeWhiteSpace() {
        String str = "jyg khjkiu  lijl k  hjh ijlij ";
        char[] ch = str.toCharArray();
        String x = "";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ch.length; i++) {
            if ((ch[i] != ' ') && (ch[i] != '\t')) {
                x = x + (ch[i]);
            }
        }
        System.out.println(x);
    }
}
