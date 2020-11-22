class Solution {
    // assume input is valid with only '0' and '1'
    // skip input validation
    public int maximalRectangle(char[][] matrix) {
        // special case handling
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int maxRectange = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int maxRectangeTemp = getMaxRectangle(matrix, i, j);
                if (maxRectangeTemp > maxRectange)
                    maxRectange = maxRectangeTemp;
            }
        }

        return maxRectange;
    }

    // use dp
    private int getMaxRectangle(char[][] matrix, int row, int col) {
        if (matrix[row][col] == '0')
            return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];
        dp[row][col] = 1;

        for (int i = row; i < rows; i++) {
            for (int j = col; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    boolean canFormRectange = false;
                    if (i > row && j > col &&
                        dp[i - 1][j] > 0 &&
                        dp[i][j - 1] > 0) {
                        canFormRectange = true;
                    } else if (i == row && j > col &&
                                dp[i][j - 1] > 0) {
                        canFormRectange = true;
                    } else if (j == col && i > row &&
                                dp[i - 1][j] > 0) {
                        canFormRectange = true;
                    }
                    if (canFormRectange)
                        dp[i][j] = (i - row + 1) * (j - col + 1);
                }
            }
        }

        int maxRectange = 0;
        for (int i = row; i < rows; i++) {
            for (int j = col; j < cols; j++) {
                if (dp[i][j] > maxRectange)
                    maxRectange = dp[i][j];
            }
        }

        return maxRectange;
    }
}