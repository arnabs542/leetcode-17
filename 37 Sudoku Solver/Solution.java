class Solution {
    private char PLACE_HOLDER = '.';

    // use recursion, dfs, backtracking
    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }

    private boolean dfs(char[][] board, int row, int col) {
        int rowTotal = board.length;
        int colTotal = board[0].length;

        // correct the position
        if(col == colTotal) {
            row += 1;
            col = 0;
            if(row == rowTotal) return true;
        }

        // find the next position to test
        int i = row;
        int j = col;
        while(i < rowTotal && j < colTotal && board[i][j] != PLACE_HOLDER) {
            j++;
            if(j == colTotal) {
                i += 1;
                j = 0;
                if(i == rowTotal) return true;
            }
        }

        // test from 1 to 9 for the current position
        for(int k = 1; k <= 9; k++){
            board[i][j] = (char) ('0' + k);
            if(isValidSudoku(board, i, j) && dfs(board, i, j + 1)){
                return true;
            }
            // backtracking to correct the current search to continue the next search
            board[i][j] = PLACE_HOLDER;
        }

        return false;
    }

    private boolean isValidSudoku(char[][] board, int row, int col) {
        int rowTotal = board.length;
        int colTotal = board[0].length;
        char c = board[row][col];

        // check current row
        for(int i = 0; i < colTotal; i++) {
            char curChar = board[row][i];
            if(i != col && curChar == c) {
                return false;
            }
        }

        // check current column
        for(int i = 0; i < rowTotal; i++) {
            char curChar = board[i][col];
            if(i != row && curChar == c) {
                return false;
            }
        }

        // check current block
        int startRow = row / 3 * 3;
        int startCol = col / 3 * 3;
        for(int i = startRow; i < startRow + 3; i++) {
            for(int j = startCol; j < startCol + 3; j++) {
                char curChar = board[i][j];
                if((i != row || j != col) && curChar == c) {
                    return false;
                }
            }
        }

        return true;
    }
}