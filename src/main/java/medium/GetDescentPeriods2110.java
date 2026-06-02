package medium;

public class GetDescentPeriods2110 {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long ans = 0;

        int descentLength = 0;
        for (int i = 1; i < n + 1; i++) {
            if (i != n && prices[i - 1] - prices[i] == 1) {
                descentLength++;
            } else {
                // 补上缺的开头数
                long descentL = descentLength != 0 ? (long) descentLength + 1 : 0;
                ans += descentL * (descentL - 1) / 2;
                descentLength = 0;
            }
        }

        return ans + n;
    }

    public static void main(String[] args) {
        GetDescentPeriods2110 alg = new GetDescentPeriods2110();
        System.out.println(alg.getDescentPeriods(
                new int[] {12,11,10,9,8,7,6,5,4,3,4,3,10,9,8,7}
        ));
    }
}
