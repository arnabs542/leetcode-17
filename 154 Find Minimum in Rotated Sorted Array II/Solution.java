/*
Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
*/

public class Solution {
	//Binary division 
	//O(lg(n)), but the worst case might be O(n)
    /*
    Hint from Leetcode:
    For case where AL == AM == AR, the minimum could be on AM’s left or right side 
    (eg, [1, 1, 1, 0, 1] or [1, 0, 1, 1, 1]). 
    In this case, we could not discard either subarrays and 
    therefore such worst case degenerates to the order of O(n).
    */
	public int findMin(int[] nums) {
        int length = nums.length;

        if (length != 0) {
        	int left = 0;
        	int right = length - 1;

        	while ((right - left) > 1) {
    			int mid = (left + right) / 2;
    			
    			if (nums[mid] < nums[left]) {
    				right = mid;
    			}
    			else if (nums[right] < nums[mid]){
    				left = mid;
    			}
    			else {
    				right --;
    			}
        	}

        	return (nums[left] < nums[right]) ? nums[left]: nums[right];
        }
        else return 0;

	}

	//The normal solution by looping the array once.
	//Complexity: O(n)
    public int findMin_Normal(int[] nums) {
        int min;
        int length = nums.length;

        if (length != 0) {
        	min = nums[0];
        	for (int t: nums) {
        		if (t < min) min = t;
        	}
        	return min;
        }
        else return 0;
    }
}