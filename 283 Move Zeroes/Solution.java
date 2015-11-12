/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Subscribe to see which companies asked this question
*/

public class Solution {
    public void moveZeroes(int[] nums) {
        int zeroCounter = 0;
        int length = nums.length;

        for (int i = 0; i < length; i ++) {
        	if (nums[i] == 0) {
        		zeroCounter ++;
        	}
        	else {
        		nums[i - zeroCounter] = nums[i];
        	}
        }

        for (int i = (length - 1); i > (length - 1 - zeroCounter); i --) {
        	nums[i] = 0;
        }

        return;
    }
}