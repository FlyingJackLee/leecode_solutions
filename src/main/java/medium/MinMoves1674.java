package medium;

public class MinMoves1674 {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] diff = new int[limit * 2 + 2];

        for (int i = 0; i < n / 2; i++) {
            int a = Math.min(nums[i], nums[n - 1 -i]);
            int b = Math.max(nums[i], nums[n - 1 -i]);

            diff[2] += 2;
            diff[a + 1] -= 1;
            diff[a + b] -= 1;
            diff[a + b + 1] -= 1;
            diff[b + limit + 1] +=1;
        }

        int min_ops = n;
        int current_ops = 0;

        for (int c = 2; c <= 2 * limit ; ++c) {
            current_ops += diff[c];
            min_ops = Math.min(current_ops, min_ops);
        }

        return min_ops;
    }
}
