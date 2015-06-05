/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/

public class Solution {
	//DP(Dynamic Programming)
    public int minPathSum(int[][] grid) {
    	int row = grid.length;
    	int col = grid[0].length;
        int[][] minPath = new int[row][col];

        //init of the min distance double array recording min path sum from the gird[0][0] to grid[i][j]
        for (int i = 0; i < row; i ++) {
        	for (int j = 0; j < col; j ++) {
        		if (i == 0 && j == 0) {
        			minPath[i][j] = grid[i][j];
        		}
        		else if (i == 0) {
        			minPath[i][j] = minPath[i][j - 1] + grid[i][j];
        		}
        		else if (j == 0) {
        			minPath[i][j] = minPath[i - 1][j] + grid[i][j];
        		}
        		else {
        			minPath[i][j] = 0;
        		}
        	}
        }

        //find the min path sum for every grid node
        for (int i = 1; i < row; i ++) {
        	for (int j = 1; j < col; j ++) {
        		minPath[i][j] = Math.min(minPath[i - 1][j], minPath[i][j - 1]) + grid[i][j];
        	}
        }

        return minPath[row - 1][col - 1];
    }
}