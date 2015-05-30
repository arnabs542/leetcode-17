/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i ++) {
            if (target == nums[i]) return i;
            if (i < length - 1 && target > nums[i] && target < nums[i + 1]) return (i + 1);
            if (i == (length - 1) && target > nums[i]) return (i + 1);
        }
        
        return 0;
    }
    
    public int searchInsert_BinarySearch(int[] nums, int target) {
        int length = nums.length;
        int headPointer = 0;
        int tailPointer = length - 1;
        int position = (headPointer + tailPointer) / 2;

        if (length == 0) return 0;

        while (position != headPointer && position != tailPointer) {
        	if (nums[position] == target) return position;
        	else if (nums[position] > target) {
        		tailPointer = position;
        	}
        	else if (nums[position] < target) {
        		headPointer = position;
        	} 

        	position = (headPointer + tailPointer) / 2;
        }

        if (target > nums[position]) position ++;

        if (position < length && target > nums[position]) position ++;

        return position;
    }
}