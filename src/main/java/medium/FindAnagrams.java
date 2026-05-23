package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>(1);

        // Goal is to make every element into 0;
        int[] window = new int[26];

        for (int i = 0; i < p.length(); i++) {
            window[p.charAt(i) - 'a']  += 1;
        }

        s.chars().limit(p.length()).map(e -> e - 'a').forEach(v -> window[v] -= 1);
        if (Arrays.stream(window).allMatch( v -> v == 0)) {
            ans.add(0);
        }

        for (int i = 1; i < s.length() - p.length() + 1 ; i++) {
           window[s.charAt(i - 1) - 'a'] += 1;
           window[s.charAt(i + p.length() - 1) - 'a'] -= 1;
            if (Arrays.stream(window).allMatch( v -> v == 0)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("abab", "ab"));
    }
}
