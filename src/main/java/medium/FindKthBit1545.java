package medium;

public class FindKthBit1545 {
    public char findKthBit(int n, int k) {
        String[] dp = new String[n];

        dp[0] = "0";

        for (int i = 1; i < dp.length; i++) {
            dp[1] = dp[i-1] + "1" + reverse(dp[i-1]);
        }

        return dp[n].charAt(k);
    }

    private String reverse(String s){
        char[] chs = s.toCharArray();
        char[] ans = new char[chs.length];

        for (int i = chs.length - 1; i >= 0 ; i--) {
            ans[i - ans.length + 1] = chs[i] == '0' ? '1' : '0';
        }
        return String.valueOf(ans);
    }
}

