package medium;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonPrefix3043 {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> seen = new HashSet<>(arr1.length);
        int ans = 0;

        for (int v : arr1) {
            while (v > 0) {
                seen.add(v);
                v /= 10;
            }
        }

        for (int v: arr2) {
            while (v > 0) {
                int n = String.valueOf(v).length();
                if (n < ans) {
                    break;
                }

                if (seen.contains(v)) {
                    ans = n;
                }
                v /= 10;

            }
        }

        return ans;
    }
}
