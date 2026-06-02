package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubarraySum560 {
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length, ans = 0, pre = 0;
        // 记录前缀和数量
        Map<Integer, Integer> map = new HashMap<>();
        // 虚拟出前缀和为0的数有一个（实际上就是本身）
        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            pre += nums[i];

            // 必定会跑到后面，所以前面没匹配到无所谓，记录数量就行
            if (map.containsKey(pre - k)) {
                ans += map.get(pre - k);
            }

            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,2,3}, 3));
    }
}
