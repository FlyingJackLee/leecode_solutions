package easy;

import java.util.Stack;

public class CheckString2124 {
    public static boolean checkString(String s) {
        return !s.contains("ba");

//        char sLast = s.charAt(0);
//
//        for (Character c: s.toCharArray()) {
//            if (sLast != c)  {
//                if (c == 'b') {
//                    sLast = 'b';
//                } else {
//                    return false;
//                }
//            }
//        }
//
//        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkString("aaabbb"));
        System.out.println("aaabbb".indexOf("ba"));
    }
}
