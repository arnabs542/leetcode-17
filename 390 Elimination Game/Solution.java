// reference: http://www.cnblogs.com/grandyang/p/5860706.html
// lastRemaining(2 * n + 1) + lastRemaining(2 * n)
// lastRemaining(2 * n) + lastRemaining(2 * (n - 1))
class Solution {
    public int lastRemaining(int n) {
        return n == 1 ? 1 : 2 * (1 + n / 2 - lastRemaining(n / 2));
    }
}
