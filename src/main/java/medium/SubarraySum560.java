package medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum560 {
    public static int subarraySum(int[] nums, int k) {
        int ans = 0, pre = 0;


        Map<Integer, Integer> map = new HashMap<>(1);
        map.put(0, 1); // 自身

        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];

            if (map.containsKey(pre - k)) {
                ans += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1,1},2));
    }
}
