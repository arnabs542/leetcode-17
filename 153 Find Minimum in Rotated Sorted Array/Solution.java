/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/

//Other Solution: http://fisherlei.blogspot.ca/2013/01/leetcode-search-in-rotated-sorted-array.html

public class Solution {
    public int findMin(int[] nums) {
        int length = nums.length;

        if (length == 1) return nums[0];
        else {
        	for (int i = 1; i < length; i ++) {
        		if (nums[i] < nums[i - 1]) {
        			return nums[i];
        		}
        	}

        	return nums[0];
        }
    }
}