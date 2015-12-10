/*
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
*/

public class Solution {
	// using slide windows method for computing continuous substring related problem
	// reference: http://www.jyuan92.com/blog/leetcode-minimum-size-subarray-sum/
    public int minSubArrayLen(int s, int[] nums) {
        int length = nums.length;
        if (length == 0) {
        	return 0;
        }

        int MAX_INT = 1000000;

        int curSum = nums[0];
        int left = 0;
        int right = 0;
        int curLen = 1;
        int minLen = MAX_INT;

        while (right < length && left < length) {
        	if (curSum >= s) {
        		if (curLen < minLen) {
        			minLen = curLen;
        		}
        		curSum -= nums[left];
        		left ++;
        		curLen --;
        	}
        	else {
        		right ++;
        		curLen ++;
        		if (right < length) {
        			curSum += nums[right];
        		}
        	}
        }

        if (minLen == MAX_INT) {
        	minLen = 0;
        }

        return minLen;
    }
}