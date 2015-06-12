/*
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

click to show spoilers.

Note:
Your solution should be in logarithmic complexity.
*/

public class Solution {
	//Binary search, complexity O(log(n)).
	public int findPeakElement(int[] nums) {
		int length = nums.length;

		int left = 0;
		int right = length - 1;

		while (left <= right) {
			if (left == right) return left;

			int mid = (left + right) / 2;

			if (mid == 0) {
				if (nums[mid] > nums[mid + 1]) {
					return mid;
				}
				else {
					left ++;
				}
			}
			else if (mid == (length - 1)) {
				if (nums[mid] > nums[mid - 1]) {
					return mid;
				}
				else {
					right --;
				}
			}
			else if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
				return mid;
			} 
			else if (nums[mid] <= nums[left] && mid != left) {
				right = mid - 1;
			}
			else if (nums[mid] <= nums[right] && mid != right) {
				left = mid + 1;
			}
			else {
				left ++;
				right --;
			}
		}

		return 0;
	}

	//This solution has complexity of O(n) by looping the array once.
    public int findPeakElement_Normal(int[] nums) {
        int length = nums.length;

        for (int i = 0; i < length; i ++) {
        	if (i == 0) {
        		if (length <= 1 || nums[i] > nums[i + 1]) {
        			return i;
        		}
        	}
        	else if (i == (length -1)) {
        		if (length <= 1 || nums[i] > nums[i - 1]) {
        			return i;
        		}
        	}
        	else if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
        		return i;
        	}
        }

        return 0;
    }
}