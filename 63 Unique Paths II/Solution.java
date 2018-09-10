class Solution {
    // we could use recursion or DP to solve the problem
    // dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowLen = obstacleGrid.length;
        int colLen = obstacleGrid[0].length;
        int[][] dp = new int[rowLen][colLen];

        // start or end point is not reachable
        if(obstacleGrid[0][0] == 1) return 0;
        if(obstacleGrid[rowLen - 1][colLen - 1] == 1) return 0;

        for(int i = 0; i < rowLen; i++) {
            for(int j = 0; j < colLen; j++) {
                // init dp
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = 0;
                }

                // recursion
                if(i >= 1 && obstacleGrid[i - 1][j] != 1) {
                    dp[i][j] += dp[i - 1][j];
                }
                if(j >= 1 && obstacleGrid[i][j - 1] != 1) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }

        return dp[rowLen - 1][colLen - 1];
    }
}