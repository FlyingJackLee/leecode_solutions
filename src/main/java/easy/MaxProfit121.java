package easy;

public class MaxProfit121 {
    public static int maxProfit(int[] prices) {
        if (prices.length == 1 ) { return 0; }
        int ans = 0;

        int minPrice = prices[0];
        int maxPrice = prices[1];
        for (int i = 1; i < prices.length; i++) {
            if (i != prices.length -1 && prices[i] < minPrice ) {
                minPrice = prices[i];
                maxPrice = prices[i + 1];
            } else {
                maxPrice = Math.max(maxPrice, prices[i]);
            }

            ans = Math.max(maxPrice-minPrice, ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] test = new int[]{
                3,2,6,5,0,3
        };
        System.out.println(maxProfit(test));
    }
}
