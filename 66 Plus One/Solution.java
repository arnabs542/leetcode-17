/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/

public class Solution {
    //This is one solution
    //Or we can simulate the process of adding, we add one variable as carry, then we add carry for eery digit together
    public int[] plusOne(int[] digits) {
    	int[] result;
        int length = digits.length;

        int t = length - 1;
        while (t >= 0 && digits[t] == 9) {
        	digits[t] = 0;
        	t --;
        }

        if (t < 0) {
        	result = new int[length + 1];
        	for (int i = 0; i < (length + 1); i ++) {
        		if (i == 0) {
        			result[i] = 1;
        		}
        		else {
        			result[i] = digits[i - 1];
        		}
        	}
        }
        else {
        	digits[t] = digits[t] + 1;
        	result = digits;
        }

        return result;

    }
}