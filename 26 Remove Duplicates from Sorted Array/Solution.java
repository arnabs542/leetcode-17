/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
*/

public class Solution {

	//set two pointer, one indicate the current node, another point to the new array node
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int length = nums.length;
        if (length == 0) return 0;
        int temp;

        for (int i = 1; i < length; i ++) {
        	temp = nums[i];
        	if (temp != nums[count]) {
        		count ++;
        		nums[count] = temp;
        	}
        }

        return (count + 1);
    }
}