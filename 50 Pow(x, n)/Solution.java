/*
Implement pow(x, n).
*/

// Reference: http://fisherlei.blogspot.ca/2012/12/leetcode-powx-n.html

// Thinking: If we use brute force method, we will get time limitation issue.
// The reason for this is that we use too many times of calculation.
// Thus, we can reduce the time of calculation by binary division.

public class Solution {
    public double myPow(double x, int n) {

    	if (n >= 0) {
    		return power(x, n);
    	}
        else {
        	return 1.0 / power(x, -n);
        }

    }

    private double power (double x, int n) {

    	if (n == 0) {
    		return 1.0;
    	}

        double temp = power (x, n / 2);

        if (n % 2 == 0) {
        	return temp * temp;
        }
        else {
        	return temp * temp * x;
        }
    }
}