/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
*/

public class Solution {
    public int numIslands(char[][] grid) {
    	int num = 0;

        int row = grid.length;
        int col = 0;
        if (row != 0) {
        	col = grid[0].length;
        }

        int[][] mark = new int[row][col];

        for (int i = 0; i < row; i ++) {
        	for (int j =0; j < col; j ++) {
        		if (grid[i][j] == '1' && mark[i][j] == 0) {
        			num ++;
        			searchMark(i, j, grid, mark, row, col);
        		}
        	}
        }

        return num;
    }

    //mark all the '1's that belongs to the same island of the current '1'
    //serach in the up, down, left and right, 4 directions
    private void searchMark (int row, int col, char[][] grid, int[][] mark, int rowN, int colN) {
    	if (grid[row][col] == '1') {
    		mark[row][col] = 1;
	    	if (row > 0 && mark[row - 1][col] == 0) {
	    		searchMark(row - 1, col, grid, mark, rowN, colN);
	    	}
	    	if (col > 0 && mark[row][col - 1] == 0) {
	    		searchMark(row, col - 1, grid, mark, rowN, colN);
	    	}
	    	if (row < (rowN - 1) && mark[row + 1][col] == 0) {
	    		searchMark(row + 1, col, grid, mark, rowN, colN);
	    	}
	    	if (col < (colN - 1) && mark[row][col + 1] == 0) {
	    		searchMark(row, col + 1, grid, mark, rowN, colN);
	    	}
	    }
    }
}