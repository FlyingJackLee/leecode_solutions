/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/2 8:37 PM
 * 4
 */
public class ReverseWords {
    public static String reverseWords(String s) {
        String[] words = s.split(" ");

        StringBuffer result = new StringBuffer();

        for (String word:words) {
            result.append(reverse(word));
        }

        //去除多余的空格
        return result.substring(0,result.length()-2).toString();
    }

    public static String reverse(String word){
        char[] s = word.toCharArray();

        int len = word.length();
        int l = 0;
        int r = len -1;

        while (l<=r){
            char temp = word.charAt(l);
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }

        return String.valueOf(s) + " ";

    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        reverseWords(s);

    }


}
