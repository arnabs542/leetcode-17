/*Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/

public class Solution {
    public int removeElement(int[] nums, int val) {
    	int counter = 0;
        int length = nums.length;

        for (int i = 0; i < length; i ++) {
        	if (nums[i] != val) {
        		nums[counter] = nums[i];
        		counter ++;
        	}
        }

        return counter;
    }
}