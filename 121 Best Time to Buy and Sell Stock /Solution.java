/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/

//Other solution: http://fisherlei.blogspot.ca/2013/01/leetcode-best-time-to-buy-and-sell.html

public class Solution {
	//DP(Dynamic Programming)
    public int maxProfit(int[] prices) {
        int length = prices.length;

        if (length == 0) return 0;

        int[] profits = new int[length];
        profits[0] = 0;

        for (int i = 1; i < length; i ++) {
        	if (prices[i] >= prices[i - 1]) {
        		profits[i] = prices[i] - prices[i - 1] + profits[i - 1];
        	}
        	else {
        		if ((prices[i] - prices[i - 1] + profits[i - 1]) > 0) {
        			profits[i] = prices[i] - prices[i - 1] + profits[i - 1];
        		}
        		else {
        			profits[i] = 0;
        		}
        	}
        }

        int max = 0;

        for (int profit: profits) {
        	if (profit > max) {
        		max = profit;
        	}
        }

        return max;
    }
}