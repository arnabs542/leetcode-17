// reference: http://blog.jerkybible.com/2016/11/11/LeetCode-452-Minimum-Number-of-Arrows-to-Burst-Balloons/
// Greedy algorithm!!!
class Solution {
    public int findMinArrowShots(int[][] points) {
        int pointsNum = points.length;
        if (pointsNum == 0) return 0;

        // sort the source array
        Arrays.sort(points, Comparator.comparing((int[] point) -> point[1]));

        int shots = 0;
        for (int i = 0; i < pointsNum; i++) {
            int curEnd = points[i][1];
            shots++;
            while ((i + 1) < pointsNum && curEnd >= points[i + 1][0]) i++;
        }

        return shots;
    }
}
