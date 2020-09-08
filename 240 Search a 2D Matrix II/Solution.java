class Solution {
    // ref: https://leetcode.com/problems/search-a-2d-matrix-ii/discuss/66140/My-concise-O(m%2Bn)-Java-solution
    public boolean searchMatrix(int[][] matrix, int target) {
        // treat top right node of the matrix as the root node of a BST
        // left nunber and below number as left and right nodes of a BST
        int rows = matrix.length;
        if (rows == 0) return false;
        int cols = matrix[0].length;
        if (cols == 0) return false;

        int curRow = 0;
        int curCol = cols - 1;
        while (curRow < rows && curCol >= 0) {
            if (matrix[curRow][curCol] == target) {
                return true;
            } else if (matrix[curRow][curCol] > target) {
                curCol--;
            } else {
                curRow++;
            }
        }
        return false;
    }
}