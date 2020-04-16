import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CodingPractise {


    @Test
    public void printFibonacci() {
        //System.out.println("Enter number");
        //int num = new Scanner(System.in).nextInt();
        int num = 7;
        for (int i = 1; i <= num; i++) {
            System.out.println(getFibo(i));
        }
    }

    /**
     * Recursion
     *
     * @param num
     * @return
     */
    private int getFibanocci(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }
        return getFibanocci(num - 1) + getFibanocci(num - 2);
    }

    /**
     * fibanocci using loop
     *
     * @param num
     * @return
     */
    private int getFibo(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }
        int f1 = 1, f2 = 1, fibo = 1;
        for (int i = 3; i <= num; i++) {
            fibo = f1 + f2;
            f1 = f2;
            f2 = fibo;
        }
        return fibo;
    }

    /**
     * check prime number
     */
    @Test
    public void checkPrime() {
        int num = 7;
        System.out.println(isPrime(num));
    }

    private boolean isPrime(int num) {
        if (num == 2 || num == 3) {
            return true;
        }
        for (int i = 2; i < num/2 + 1; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * String palindrome
     */
    @Test
    public void checkPalindrome() {
        String str = "rajesh";
        if (str.equals(reverseString(str))) {
            System.out.println(String.format("%s is a palindrome", str));
        } else {
            System.out.println(String.format("%s is not a palindrome", str));
        }
    }

    private String reverseString(String str) {
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse = reverse + (str.charAt(i));
        }
        return reverse;
    }

    @Test
    public void checkIntPalindrome() {
        int num = 8998;
        if (num == checkIntPal(num)) {
            System.out.println(num + " is a palindrome");
        } else {
            System.out.println(num + " is not a palindrome");
        }
    }

    private int checkIntPal(int num) {
        int reversed = 0;
        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }

    @Test
    public void checkArmstrong() {
        int num = 153;
        int sum = 0;
        while (num != 0) {
            int d = num % 10;
            sum = sum + (d * d * d);
            num /= 10;
        }
        System.out.println(sum);
    }

    /**
     * get cube of number
     */
    @Test
    public void getCube() {
        int n = 4;
        int index = n * n;
        int ans = 0;
        for (int i = 0; i < index; i++) {
            ans += n;
        }
        System.out.println(ans);
    }

    @Test
    public static void drawPyramidPattern() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    @Test
    public static void drawPyramidPatternNum() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print(k+" ");
            }
            System.out.println();
        }
    }


    @Test
    public void findDuplicatesInString() {
        String str = "jhgfhfytf";
        char[] ch = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (ch[i] == ch[j]) {
                    System.out.println(ch[i]);
                }
            }
        }
    }


    @Test
    public static void printDuplicateCharacters() {
        String wor = "jhg";
        char[] characters = wor.toCharArray();
        // build HashMap with character and number of times they appear in String
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        for (Character ch : characters) {
            if (charMap.containsKey(ch)) {
                charMap.put(ch, charMap.get(ch) + 1);
            } else {
                charMap.put(ch, 1);
            }
        } // Iterate through HashMap to print all duplicate characters of String
        Set<Map.Entry<Character, Integer>> entrySet = charMap.entrySet();
        System.out.printf("List of duplicate characters in String '%s' %n", wor);
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue() > 1) {
                System.out.printf("%s : %d %n", entry.getKey(), entry.getValue());
            }
        }
    }

}
