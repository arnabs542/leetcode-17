/*
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.

Credits:
Special thanks to @amrsaqr for adding this problem and creating all test cases.

Subscribe to see which companies asked this question
*/

public class Solution {
	//reference: http://www.cnblogs.com/grandyang/p/4431646.html
	public int rangeBitwiseAnd(int m, int n) {
		int count = 0;
		while (m != n) {
			m = m >> 1;
			n = n >> 1;
			count ++;
		}

		for (int i = 0; i < count; i ++) {
			m = m << 1;
		}

		return m;
	}

    public int rangeBitwiseAnd_1(int m, int n) {
    	if (m == n) {
    		return m;
    	}

        int difference = Math.abs(m - n);
        int t = 1;
        int len = 0;
        while (difference >= t) {
        	t = t << 1;
        	len ++;
        }

        return m & n & t;
    }
}