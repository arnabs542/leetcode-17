/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

public class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int buyPrice = 0;
        int sellPrice = 0;

        int currentPrice = 0;
        int previousPrice = 0;
        int followingPrice = 0;
        int profit = 0;

        for (int i = 0; i < length; i ++) {
        	currentPrice = prices[i];
        	if (i != 0) previousPrice = prices[i - 1];
        	if (i != (length - 1)) followingPrice = prices[i + 1];

        	if (i == 0) {
        		if (currentPrice < followingPrice) {
        			buyPrice = currentPrice;
        		}
        	}
        	else if (i == (length - 1)) {
        		if (currentPrice > previousPrice) {
        			sellPrice = currentPrice;
        			profit += (sellPrice - buyPrice);
        		}
        	}
        	else if (currentPrice <= previousPrice && currentPrice < followingPrice) {
        		buyPrice = currentPrice;
        	}
        	else if (currentPrice > previousPrice && currentPrice >= followingPrice) {
        		sellPrice = currentPrice;
        		profit += (sellPrice - buyPrice);
        	}
        }

        return profit;
    }
}