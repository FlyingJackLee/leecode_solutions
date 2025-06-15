package easy;

import java.util.Arrays;

public class FindMaxAverage643 {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        for (int i = 1; i + k - 1 < nums.length; i++) {
            sum = sum - nums[i-1] + nums[i+k-1];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum / (double) k;
    }
}
