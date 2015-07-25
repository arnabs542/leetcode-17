/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

For example, given array S = {-1 2 1 -4}, and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

public class Solution {
	//Reference: http://fisherlei.blogspot.ca/2013/01/leetcode-3-sum-solution.html
	//two pointer scan
    public int threeSumClosest(int[] nums, int target) {
    	int len = nums.length;
    	int result = 0;

    	int distance = 1000000;

    	Arrays.sort(nums);

    	for (int i = 0; i < len - 2; i ++) {
    		int cur = nums[i];
    		int targetTemp = nums[i] + twoSumClosest(nums, i + 1, len - 1, target - nums[i]);
    		if (target == targetTemp) {
    			return target;
    		}
    		if (Math.abs(target - targetTemp) < distance) {
    			result = targetTemp;
    			distance = Math.abs(target - targetTemp);
    		}
    	}

    	return result;
    }

    private int twoSumClosest(int[] nums, int start, int end, int target) {
    	int left = start;
    	int right = end;

    	int distance = Math.abs(nums[left] + nums[right] - target);
    	int result = nums[left] + nums[right];

    	while (left < right) {
    		int targetTemp = nums[left] + nums[right];

    		if (Math.abs(target - targetTemp) < distance) {
    			result = targetTemp;
    			distance = Math.abs(nums[left] + nums[right] - target);
    		}

    		if (targetTemp == target) {
    			return target;
    		}
    		else if (targetTemp > target) {
    			right --;
    		}
    		//targetTemp < target
    		else {
    			left ++;
    		}
    	}

    	return result;
    }
}