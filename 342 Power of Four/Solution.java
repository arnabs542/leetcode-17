// reference: https://www.hrwhisper.me/leetcode-power-four/
// One of a good solution for this problem is to ultilize bit operations to solve the problem
// list all numvers that is the power of 4 in bits and observe its pattern and use bit operations
public class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) ==0  && (num & 0x55555555) !=0;
    }
}
