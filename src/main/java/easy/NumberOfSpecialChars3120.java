package easy;

import java.util.Arrays;

public class NumberOfSpecialChars3120 {
    public int numberOfSpecialChars(String word) {
        int[] map = new int[26];
        int ans = 0;

        for(char c: word.toCharArray()){
            int index = Character.toLowerCase(c) - 'a';

            if (map[index] == 0){
                map[index] += c;
            } else {
                if(c != map[index] && map[index] != 32){
                    map[index] = Math.abs(map[index] - c);
                    ans ++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfSpecialChars3120().numberOfSpecialChars("abBCab"));
    }
}
