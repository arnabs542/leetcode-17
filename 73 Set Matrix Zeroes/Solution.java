/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/

public class Solution {
    public void setZeroes(int[][] matrix) {
    	List<Integer> rows = new ArrayList<Integer>();
    	List<Integer> cols = new ArrayList<Integer>();

    	int rowNum = matrix.length;
    	if (rowNum == 0) return;
    	int colNum = matrix[0].length;
    	if (colNum == 0) return;

    	for (int i = 0; i < rowNum; i ++) {
    		for (int j = 0; j < colNum; j ++) {
    			if (matrix[i][j] == 0) {
    				if (!rows.contains(i)) {
    					rows.add(i);
    				}
    				if (!cols.contains(j)) {
    					cols.add(j);
    				}
    			}
    		}
    	}

    	for (int i : rows) {
    		for (int j = 0; j < colNum; j ++) {
    			matrix[i][j] = 0;
    		}
    	}

    	for (int j : cols) {
    		for (int i = 0; i < rowNum; i ++) {
    			matrix[i][j] = 0;
    		}
    	}

    	return;        
    }
}