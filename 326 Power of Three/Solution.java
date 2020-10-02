class Solution {
    // ref: https://leetcode.com/problems/power-of-three/discuss/77876/**-A-summary-of-all-solutions-(new-method-included-at-15%3A30pm-Jan-8th)
    public boolean isPowerOfThree(int n) {
        while (n > 1) {
            if (n % 3 != 0) return false;
            n /= 3;
        }
        return n == 1;
    }
}