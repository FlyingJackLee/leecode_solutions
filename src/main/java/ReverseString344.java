/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/2 8:33 PM
 * 4
 */
public class ReverseString344 {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length -1;

        while (l<=r){
            char temp = s[l];
            s[l] =  s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
