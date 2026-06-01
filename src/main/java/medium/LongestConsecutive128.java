package medium;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutive128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0){
            return 0;
        }

        int min = Integer.MAX_VALUE, max = 0;
        for (int num: nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }

        if (min == max) return 1;

        long range = (long) max - min + 1;

        if (range >= nums.length * 2L ) {
            return bigRange(nums);
        }

        return smallRange(nums, (int) range, min);
    }

    private static int smallRange(int[] nums, int range, int min) {
        boolean[] exists = new boolean[range];
        for (int num: nums) {
            exists[num - min] = true;
        }

        int count = 0;
        int ans = 0;

        for (boolean exist : exists) {
            if (exist) {
                count++;
            } else {
                count = 0;
            }
            ans = Math.max(ans, count);
        }

        return ans;
    }

    private int bigRange(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, false);
        }

        int ans = 0;

        for (Map.Entry<Integer, Boolean> entry: map.entrySet()) {
            if (entry.getValue()) {
                continue;
            }

            int key = entry.getKey();
            map.put(key, true);
            int count = 1;

            while (map.containsKey(key + 1)) {
                map.put(++key, true);
                count++;
            }

            key = entry.getKey();
            while (map.containsKey(key - 1)) {
                map.put(--key, true);
                count++;
            }

            ans = Math.max(ans, count);
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestConsecutive128 alg = new LongestConsecutive128();
        System.out.println(alg.longestConsecutive(
                new int[]{4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3}
        ));
    }
}
