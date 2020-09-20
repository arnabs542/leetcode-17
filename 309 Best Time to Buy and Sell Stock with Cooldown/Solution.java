class Solution {
    // another good solution:
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75927/Share-my-thinking-process
    public int maxProfit(int[] prices) {
        // DP
        int maxProfit = 0;
        int days = prices.length;

        // special case handling
        if (days == 0) return 0;

        // profit[i] means the maximum profit when the last sell activity is at ith day
        int[] profit = new int[days];

        // find max profit by DP
        for (int i = 0; i < days; i++) {
            int minPreviousPrice = prices[i];
            for (int j = i - 1; j >= 0; j--) {
                // pruning
                if (prices[j] < minPreviousPrice) {
                    minPreviousPrice = prices[j];
                    int currentMax = 0;
                    if (j >= 2) {
                        int k = j - 2;
                        currentMax = profit[k];
                        while (k >= 0) {
                            if (profit[k] > currentMax) currentMax = profit[k];
                            k--;
                        }
                    }
                    currentMax += prices[i] - prices[j];
                    if (currentMax > profit[i]) profit[i] = currentMax;
                    if (currentMax > maxProfit) maxProfit = currentMax;
                }
            }
        }

        return maxProfit;
    }
}