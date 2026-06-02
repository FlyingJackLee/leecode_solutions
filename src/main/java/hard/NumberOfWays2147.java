package hard;

public class NumberOfWays2147 {
    private static final int mod = 1000000007;
    public int numberOfWays(String corridor) {
        int n = corridor.length();

        int cnt = 0; // 当前座位的坐标
        int prev = -1; // 上一个座位的坐标
        int ans = 1;

        for (int i = 0; i < n; i++) {
            if (corridor.charAt(i) == 'S'){
                cnt++;

                // 如果找到了>3的位置，证明可以放挡板了
                if (cnt >= 3 && cnt % 2 == 1){
                    // 有i - prev - 1个植物，有i - prev种放divider的方式
                    //  每一次可以与前面重排列，所以相乘
                    ans = (int) ((long) ans * (i - prev) % mod );
                }

                prev = i;
            }
        }

        // 为奇数没法凑刚好2个位置
        if (cnt < 2 || cnt % 2 != 0) {
            ans = 0;
        }

        return ans;
    }
}
