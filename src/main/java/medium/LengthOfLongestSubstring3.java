package medium;

import easy.NumberOfSpecialChars3120;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring3 {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;

        Set<Character> set = new HashSet<>();

        for (int l = 0; l < n; l++) {
            for (int r = l + set.size(); r < n && !set.contains(s.charAt(r)); r++) {
                set.add(s.charAt(r));
                ans = Math.max(ans, set.size());
            }

            set.remove(s.charAt(l));
        }

        return ans;
    }

    public static void main(String[] args) {
         System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring(" "));
    }
}
