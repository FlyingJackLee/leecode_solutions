package medium;

import java.util.Arrays;

public class CanReach1871 {
    public static boolean canReach(String s, int minJump, int maxJump) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;

        int[] pre = new int[n];
        pre[0] = 1;

        for (int i = 1; i < n; i++) {
            if (cs[i] == '1') {
                dp[i] = false;
                pre[i] = pre[i - 1];
                continue;
            }

            int left = i - maxJump;
            int right = i - minJump;

            if (right < 0) {
                dp[i] = false;
            } else {
                int total = pre[right] - (left > 0 ? pre[left - 1] : 0); // 区间内是否存在可达
                dp[i] = total > 0;
            }

            pre[i] = pre[i - 1] + (dp[i] ? 1 : 0);
        }

        return dp[n-1];
    }

    public static void main(String[] args) {
        System.out.println(canReach("011010",2,3));
    }
}
