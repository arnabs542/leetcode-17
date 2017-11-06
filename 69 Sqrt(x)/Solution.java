class Solution {
    // we can try binary search here
    // time complexity is log(x) then
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        long start = 0;
        long end = x;
        while (start < end && end - start > 1) {
            long mid = (start + end) / 2;
            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid > x) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return (int)start;
    }
}
