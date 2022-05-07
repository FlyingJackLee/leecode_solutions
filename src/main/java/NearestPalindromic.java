import java.math.BigDecimal;
import java.util.Arrays;

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/2 9:47 PM
 * 4
 */
public class NearestPalindromic {
    public static boolean isPalindromic(long number){
        char[] bits = String.valueOf(number).toCharArray();

        if(bits.length == 1){
            return true;
        }

        for (int i = 0; i < bits.length / 2; i++) {
            if (bits[i] != bits[bits.length - i - 1]){
                return false;
            }
        }

        return true;
    }


    public static String nearestPalindromic(String n) {

        long number = Long.parseLong(n);

        long left = number - 1;
        long right = number + 1;


        while (true){
            if (isPalindromic(left)){
                return String.valueOf(left);
            }

            if (isPalindromic(right)){
                return String.valueOf(right);
            }

            right++;
            left--;
        }
//
//        int diffLeft = Math.abs(left - number);
//        int diffRight =  Math.abs(right - number);
//
//        return String.valueOf ( diffRight == diffLeft  ?
//                Math.min(left,right) :
//                diffLeft < diffRight ? left : right
//                );
//


//        int length = n.length();
//
//        if (length ==1){
//            return String.valueOf(Integer.parseInt(n) - 1);
//        }
//
//
//        StringBuffer result = new StringBuffer();
//        for (int i = 0; i < length/2; i++) {
//            result.append(n.charAt(i));
//        }
//
//        String reverse = reverseWord(result.toString());
//
//        if (length%2 == 1 && length != 1){
//            result.append(n.charAt(length/2));
//        }
//
//        result.append(reverse);
//
//
//        return result.toString();

    }

    public static String reverseWord(String word){
        StringBuffer result = new StringBuffer();

        for (int i = word.length() - 1; i >= 0; i--) {
            result.append(word.charAt(i));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String test = "123";
        nearestPalindromic(test);
    }
}
