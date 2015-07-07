/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

public class Solution {
	//use binary search
	public int[] searchRange(int[] nums, int target) {
    	int lTarget = -1;
    	int rTarget = -1;
        int len = nums.length;

        //find the target using binary search
        int left = 0;
        int right = len - 1;
        int mid = 0;
        boolean found = false;
        while (left <= right) {
        	mid = (left + right) / 2;

        	if (nums[mid] == target) {
        		found = true;
        		break;
        	}
        	else if (nums[mid] < target) {
        		left = mid + 1;
        	}
        	else {
        		right = mid - 1;
        	}
        }
        
        //find the left and right position of the element
        if (found) {
        	int leftBound = left;
        	int rightBound = right;
        	int midBound = mid;

        	//find the left position of the element using binary search
        	right = mid;
        	while (left < right) {
        		mid = (left + right) / 2;
        		if (nums[mid] == target) {
        			right = mid;
        		}
        		else {
        			left = mid + 1;
        		}
        	}

        	lTarget = left;

        	//find the right position of the element using binary search
        	left = midBound;
        	right = rightBound;
        	while (left < right) {
        		mid = (left + right) / 2;
        		if (nums[mid] == target) {
        			left = mid;
        			if ((right - left) == 1) {
        				if (nums[right] == target) {
        					left = right;
        				}
        				break;
        			}
        		}
        		else {
        			right = mid - 1;
        		}
        	}

        	rTarget = left;
        }
        
        int[] result = {lTarget, rTarget};

        return result;
    }
}