package medium;

/**
 * @author Zumin Li
 * @date 2025/6/13 12:49
 */
public class Rob90 {
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return rob(nums, 0, n -1);
        }

        return Math.max(
                rob(nums, 0, n - 2),
                rob(nums, 1, n - 1)
        );
    }

    public static int rob(int[] nums, int start, int end) {
        if (end - start <= 0) {
            return nums[start];
        }

        if (end - start == 1) {
            return Math.max(nums[start], nums[end]);
        }


        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(
                    first + nums[i],
                    second
            );
            first = temp;

        }

        return second;
    }
}
