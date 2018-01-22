// reference: http://blog.csdn.net/zarlove/article/details/78323469
// Use DP method for this problem, the most important thing is that we can hold maximum of 1 stcok
// thus for each day, we could only have two statuses, either we hold 1 stock or 0
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len == 0) return 0;

        int noStock = 0;
        int oneStock = -1 * (prices[0]);

        for (int i = 1; i < len; i++) {
            noStock = Math.max(noStock, oneStock + prices[i] - fee);
            oneStock = Math.max(oneStock, noStock - prices[i]);
        }

        return noStock;
    }

    public int maxProfit_dp_not_good(int[] prices, int fee) {
        int len = prices.length;

        if (len == 0) return 0;

        int[] dp = new int[len];
        dp[0] = 0;

        for (int i = 1; i < len; i++) {
            if (prices[i] < prices[i - 1]) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1];
                for (int j = i - 1; j >= 0; j--) {
                    if ((prices[i] - prices[j] - fee) > 0) {
                        if (j >= 1) {
                            dp[i] = Math.max(dp[j - 1] + prices[i] - prices[j] - fee, dp[i]);
                        } else {
                            dp[i] = Math.max(prices[i] - prices[j] - fee, dp[i]);
                        }
                    }
                }
            }
        }

        return dp[len - 1];
    }
}
