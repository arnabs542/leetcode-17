/*
Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
*/

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int counter = 0;
        int temp = n;

        while (temp != 0) {
        	//if ((Math.abs(temp) % 2) == 1) {
        	if (1 == (1 & temp)) {
        		counter++;
        	}
        	
        	temp = temp >>> 1;
        }

        return counter;
    }
}