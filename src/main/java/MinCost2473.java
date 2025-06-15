public class MinCost2473 {
    public static long[] minCost(int n, int[][] roads, int[] appleCost, int k) {
        long[][] dp = new long[n][n];
        // 初始化dp数组
        for (int[] road : roads) {
            dp[road[0] - 1][road[1] - 1] = (long) road[2] * ( k + 1);
            dp[road[1] - 1][road[0] - 1] = (long) road[2] * ( k + 1);
        }


        long[] res = new long[n];
//        for (int i = 0; i < n; i++) {
//            res[i] = appleCost[i];
//
//            for (int j = 0; j < n; j++) {
//                // 跳过无效路径
//                if ( i == j ) {
//                    continue;
//                }
//
//                long val = pathLength(i, j, dp);
//                if (val < Long.MAX_VALUE  - appleCost[j]) {
//                    res[i] = Math.min(res[i], val + appleCost[j]);
//                }
//            }
//        }

        return res;
    }

}
