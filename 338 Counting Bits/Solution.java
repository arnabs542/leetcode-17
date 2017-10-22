// reference: http://www.cnblogs.com/grandyang/p/5294255.html
// use solution 3 in the ariticle
// This suliton is similar to DP method, we can have recursion function defined to solve the problem
// Count(n) = n / 2 (if n is even)
// Count(n) = n / 2 + 1 (if n is odd)
class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & 1) == 1) {
                result[i] = result[i / 2] + 1;
            } else {
                result[i] = result[i / 2];
            }
        }
        return result;
    }
}
