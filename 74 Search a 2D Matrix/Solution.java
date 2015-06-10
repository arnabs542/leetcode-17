/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/

public class Solution {
	//Use binary search twice.
	//First search the row then the col.
	public boolean searchMatrix(int[][] matrix, int target) {
		int height = matrix.length;
    	if (height == 0) return false;

		int width = matrix[0].length;
		if (width == 0) return false;

		int start;
		int end;

		//start searching the decide the row number
		if (matrix[height - 1][width - 1] < target || matrix[0][0] > target) return false;
		start = 0;
		end = height - 1;
		while (start < end) {
			int mid = (start + end) / 2;
			if (matrix[mid][width - 1] == target) {
				return true;
			}
			else if (matrix[mid][width - 1] > target) {
				end = mid;
			}
			else {
				start = mid + 1;
			}
		}

		//start searching to decide the col number
		int row = start;
		start = 0;
		end = width - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (matrix[row][mid] == target) {
				return true;
			}
			else if (matrix[row][mid] > target) {
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}

		return false;
	}

	//Similar to Binary Search using coordinate transformation
    public boolean searchMatrix_BinarySearch(int[][] matrix, int target) {
    	int height = matrix.length;

    	if (height == 0) return false;

		int width = matrix[0].length;
		int num = height * width;
		int left = 0;
		int right = num - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			int x = mid / width;
			int y = mid % width;

			if (matrix[x][y] == target) {
				return true;
			}
			else if (matrix[x][y] > target) {
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}

    	return false;
    }
}