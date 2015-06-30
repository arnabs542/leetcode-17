/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

public class Solution {
	//Reference: http://fisherlei.blogspot.ca/2013/01/leetcode-search-in-rotated-sorted-array.html
	public int search (int[] nums, int target) {
		int len = nums.length;

		if (len == 0) {
			return -1;
		}

		if (len == 1) {
			if (nums[0] == target) {
				return 0;
			}
			else {
				return -1;
			}
		}

		int l = 0;
		int r = len - 1;
		int mid = (l + r) / 2;

		while (l <= r) {
			if (nums[mid] == target) {
				return mid;
			}

			if (nums[l] <= nums[mid]) {
				if (nums[l] <= target && target < nums[mid]) {
					r = mid - 1;
				}
				else {
					l = mid + 1;
				}
				mid = (l + r) / 2;
			}
			else if (nums[l] > nums[mid]) {
				if (nums[mid] < target && target <= nums[r]) {
					l = mid + 1;
				}
				else {
					r = mid - 1;
				}
				mid = (l + r) / 2;
			}
		}

		return -1;
	}

	//the most common solution(just ignore it althout it can be accepted by the test)
    public int search_ignore(int[] nums, int target) {
        int len = nums.length;

        for (int i = 0; i < len; i ++) {
        	if (nums[i] == target) {
        		return i;
        	}
        }

        return -1;
    }
}