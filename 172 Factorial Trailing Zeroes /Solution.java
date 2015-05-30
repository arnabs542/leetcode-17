/*
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
*/

// Solution : http://www.geeksforgeeks.org/count-trailing-zeroes-factorial-number/
// Solution : https://github.com/yadongwen/leetcode/blob/master/Factorial%20Trailing%20Zeroes.java

public class Solution {
    public int trailingZeroes(int n) {
      int retval = 0;
        while (n > 0) {
            retval += n / 5;
            n /= 5;
        }
        return retval;
    }

}