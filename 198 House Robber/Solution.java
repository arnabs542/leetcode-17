/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/

public class Solution {
	//Dynamic programming
    public int rob_1(int[] nums) {
    	int len = nums.length;
        int[] result = new int[len];

        if (len == 0) return 0;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);

        for (int i = 0; i < len; i ++) {
        	if (i <= 1) {
        		result[i] = nums[i];
        	}
        	if (i > 1) {
        		int maxTemp = 0;
        		for (int j = 0; j <= i - 2; j ++) {
        			if (result[j] > maxTemp) {
        				maxTemp = result[j];
        			}
        		}
        		result[i] = Math.max(result[i - 1], maxTemp + nums[i]);
        	}
        }

        return result[len - 1];
    }

    //Dynamic programming
     public int rob(int[] nums) {
    	int len = nums.length;
        int[] result = new int[len];

        if (len == 0) return 0;
        if (len == 1) return nums[0];

        for (int i = 0; i < len; i ++) {
        	if (i == 0) {
        		result[i] = nums[i];
        	}
        	if (i == 1) {
        		result[i] = Math.max(nums[0], nums[1]);
        	}
        	if (i > 1) {
        		result[i] = Math.max(result[i - 1], result[i - 2] + nums[i]);
        	}
        }

        return result[len - 1];
    }
}