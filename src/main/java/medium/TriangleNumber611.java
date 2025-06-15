package medium;

import java.util.Arrays;

/**
 * @author Zumin Li
 * @date 2025/6/14 13:01
 */
public class TriangleNumber611 {
    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int left = i + 1; left < n; left++) {
                int right = left;

                while (right + 1 < n && nums[right + 1] < nums[i] + nums[left]) {
                    ++right;
                }

                count += Math.max(right - left, 0);
            }
        }
        return count;
    }
}
