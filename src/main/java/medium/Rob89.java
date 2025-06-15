package medium;

/**
 * @author Zumin Li
 * @date 2025/6/13 2:14
 */
public class Rob89 {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1){
            return nums[0];
        }
        if (n == 2){
            return Math.max(nums[0], nums[1]);
        }

        int first = nums[0], second = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }

        return second;
    }

    private int rob(int index, int[] nums){
        if (index == 0 ) {
            return nums[0];
        }
        if (index == 1) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(
                nums[index] + rob(index - 2, nums),
                nums[index] + rob(index + 3, nums)
        );

    }
}
