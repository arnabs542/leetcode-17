/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/

public class Solution {
    public boolean canJump(int[] nums) {
    	int len = nums.length;
    	int maxPosition = 0;
    	int t = 0;

        while (t <= maxPosition && t < len) {
        	int maxPositionTemp = t + nums[t];
        	if (maxPositionTemp > maxPosition) {
        		maxPosition = maxPositionTemp;
        	}
        	t ++;
        }

        if (maxPosition >= (len - 1)) {
        	return true;
        }

        return false;
    }
}