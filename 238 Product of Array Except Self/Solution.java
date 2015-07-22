/*
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
*/

public class Solution {
    public int[] productExceptSelf(int[] nums) {
    	int len = nums.length;
    	//the int array that stores the product of all the left elements of the current element
    	int[] leftProd = new int[len];
    	//the int array that stores the product of all the right elements of the current element
    	int[] rightProd = new int[len];
    	//the int array that stores the product of all elements except for the current element
    	int[] prod = new int[len];

    	//init of the leftProd
        int leftProduct = 1;
        leftProd[0] = 1;
        for (int i = 1; i < len; i ++) {
        	leftProduct *= nums[i - 1];
        	leftProd[i] = leftProduct;
        }

        //init of the rightProd
        int rightProduct = 1;
        rightProd[len - 1] = 1;
        for (int i = len - 2; i >= 0; i --) {
        	rightProduct *= nums[i + 1];
        	rightProd[i] = rightProduct;
        }

        //init of the prod
        for (int i = 0; i < len; i ++) {
        	prod[i] = leftProd[i] * rightProd[i];
        }

        return prod;
    }
}