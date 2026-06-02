package easy;

import java.util.Arrays;

public class MinimumCost2144 {
    public static int minimumCost(int[] cost) {
        Arrays.sort(cost);

        int n = cost.length;
        int ans = 0;

        for (int i = n - 1; i >= 0; --i) {
            if ((n - 1 - i) % 3 != 2) {
                ans += cost[i];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minimumCost(new int[]{
                6,5,7,9,2,2
        }));
        System.out.println(minimumCost(new int[]{
                1,2,3
        }));
    }
}
