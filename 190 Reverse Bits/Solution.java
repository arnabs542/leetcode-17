/*
Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?

Related problem: Reverse Integer
*/

//Another solution by swapping bit: http://www.programcreek.com/2014/03/leetcode-reverse-bits-java/

public class Solution {
	static int INT_LEN = 32;

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;

        Queue<Integer> queue = new LinkedList<Integer>();

        while (n != 0) {
        	int temp = n & 1;
        	queue.add(temp);
        	n = n >>> 1;
        }

        for (int i = 0; i < INT_LEN; i ++) {
        	result = result << 1;
        	if (queue.peek() != null) {
        		result += queue.remove();
        	}
        }

        return result;
    }
}