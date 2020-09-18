class Solution {
    public void gameOfLife(int[][] board) {
        // we can do this either in-place or use extra space
        // it should be straightforward to use extra space, let's try do it in-place
        // to do it in-place, let's introduce new number:
        // 2: original 0, will be 1 for the next gen, 3: original 1, will be 0 for the next gen

        // assume valid board input, otherwise need special case handling
        int rows = board.length;
        int columns = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int aliveNeighbors = getAliveNeighbors(board, i, j);
                if (aliveNeighbors < 2) {
                    // rule 1
                    if (board[i][j] == 1) board[i][j] = 3;
                } else if (aliveNeighbors > 3) {
                    // rule 3
                    if (board[i][j] == 1) board[i][j] = 3;
                } else if (aliveNeighbors == 3) {
                    // rule 4
                    if (board[i][j] == 0) board[i][j] = 2;
                }
            }
        }

        updateToNextGeneration(board);
    }

    private boolean isAlive(int val) {
        return (val == 1 || val == 3);
    }

    private int getAliveNeighbors(int[][] board, int row, int col) {
        int rows = board.length;
        int columns = board[0].length;

        int aliveNeighborCount = 0;

        // up
        if (row >= 1 && isAlive(board[row - 1][col])) aliveNeighborCount++;
        // down
        if (row < (rows - 1) && isAlive(board[row + 1][col])) aliveNeighborCount++;
        // left
        if (col >= 1 && isAlive(board[row][col - 1])) aliveNeighborCount++;
        // right
        if (col < columns - 1 && isAlive(board[row][col + 1])) aliveNeighborCount++;
        // left top
        if (row >= 1 && col >= 1 && isAlive(board[row - 1][col - 1])) aliveNeighborCount++;
        // right top
        if (row >= 1 && col < columns - 1 && isAlive(board[row - 1][col + 1])) aliveNeighborCount++;
        // left bottom
        if (row < rows - 1 && col >= 1 && isAlive(board[row + 1][col - 1])) aliveNeighborCount++;
        // right bottom
        if (row < rows - 1 && col < columns - 1 && isAlive(board[row + 1][col + 1])) aliveNeighborCount++;
        return aliveNeighborCount;
    }

    private void updateToNextGeneration(int[][] board) {
        int rows = board.length;
        int columns = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == 2) board[i][j] = 1;
                else if (board[i][j] == 3) board[i][j] = 0;
            }
        }
    }
}