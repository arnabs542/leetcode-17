/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/

//Reference: http://fisherlei.blogspot.ca/2013/01/leetcode-rotate-image.html

public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 0 || n != matrix[0].length) return;

        //Fold diagonally first
        for (int i = 0; i < n; i ++) {
        	for (int j = 0; j < (n - i); j ++) {
        		swap(matrix, i, j, (n - 1 - j), (n - 1 - i));
        	}
        }

        //Reverse
        for (int i = 0; i < (n / 2); i ++) {
        	for (int j = 0; j < n; j ++) {
        		swap(matrix, i, j, (n - 1 -i), j);
        	}
        }
    }

    private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
    	int temp = matrix[x1][y1];
    	matrix[x1][y1] = matrix[x2][y2];
    	matrix[x2][y2] = temp;
    }
}