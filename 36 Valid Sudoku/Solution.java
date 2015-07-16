/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rowNum = board.length;
        int colNum = 0;

        if (rowNum != 0) {
        	colNum = board[0].length;
        	if (colNum == 0) return false;
        }
        else {
        	return false;
        }

        // if (rowNum != colNum) return false;
        if ((rowNum % 3 != 0) || (colNum % 3 != 0)) return false;

        boolean result = true;

        for (int i = 0; i < rowNum; i ++) {
        	boolean temp = isValidSudokuRow(board[i]);
        	if (!temp) {
        		return temp;
        	}
        }

        for (int i = 0; i < colNum; i ++) {
        	boolean temp = isValidSudokuCol(board, i);
        	if (!temp) {
        		return temp;
        	}
        }

        boolean temp = isValidSudokuSubBox(board, rowNum, colNum);
    	if (!temp) {
    		return temp;
    	}

        return result;
    }

    private boolean isValidSudokuRow (char[] row) {
    	boolean result = true;
    	Set<Character> set = new HashSet<Character>();

    	for (char e: row) {
    		if ((e >= '0' && e <= '9') || e == '.') {
    			if (e != '.') {
    				if (set.contains(e)) {
    					return false;
    				}
    				else {
    					set.add(e);
    				}
    			}
    		}
    		else {
    			return false;
    		}
    	}

    	return result;
    }

    private boolean isValidSudokuCol (char[][] board, int col) {
    	boolean result = true;
    	int row = board.length;
    	Set<Character> set = new HashSet<Character>();

    	for (int i = 0; i < row; i ++) {
    		char e = board[i][col];

    		if ((e >= '0' && e <= '9') || e == '.') {
    			if (e != '.') {
    				if (set.contains(e)) {
    					return false;
    				}
    				else {
    					set.add(e);
    				}
    			}
    		}
    		else {
    			return false;
    		}
    	}

    	return result;
    }

    private boolean isValidSudokuSubBox (char[][] board, int row, int col) {
    	boolean result = true;

    	int numSubBoxRow = row / 3;
    	int numSubBoxCol = col / 3;

    	for (int i = 0; i < numSubBoxRow; i ++) {
    		for (int j = 0; j < numSubBoxCol; j ++) {
    			Set<Character> set = new HashSet<Character>();

    			int startRow = i * 3;
    			int startCol = j * 3;

    			for (int rowTemp = startRow; rowTemp < startRow + 3; rowTemp ++) {
    				for (int colTemp = startCol; colTemp < startCol + 3; colTemp ++) {
    					char e = board[rowTemp][colTemp];

			    		if ((e >= '0' && e <= '9') || e == '.') {
			    			if (e != '.') {
			    				if (set.contains(e)) {
			    					return false;
			    				}
			    				else {
			    					set.add(e);
			    				}
			    			}
			    		}
			    		else {
			    			return false;
			    		}
    				}
    			}
    		}
    	}

    	return result;
    }
}