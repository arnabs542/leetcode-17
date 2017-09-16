class Solution {
    public int hammingDistance(int x, int y) {
        int diff = 0;
        while (x != 0 || y != 0) {
            int curX = 0;
            int curY = 0;
            if (x != 0) {
                curX = x & 1;
                x = x >>> 1;
            }
            if (y != 0) {
                curY = y & 1;
                y = y >>> 1;
            }
            if (curX != curY) diff++;
        }
        return diff;
    }
}
