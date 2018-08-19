class Solution {
    // global virable to save result/ we can push as parameter as recursion input as well
	private List<List<String>> result = null;;

    // back tracking methodology
    public List<List<String>> solveNQueens(int n) {
        initResult();

        char[][] chessBoard = initChessBoard(n);
        // DFS
        for (int col = 0; col < n; col++) {
            chessBoard[0][col] = 'Q';
            solveNQueens(chessBoard, 1);
            chessBoard[0][col] = '.';
        }

        return getResult();
    }

    // DFS to search possible solutions row by row
    private void solveNQueens(char[][] chessBoard, int startRow) {
        int rowNum = chessBoard.length;
        int colNum = chessBoard[0].length;

        if (startRow >= rowNum) {
            saveToResult(chessBoard);
            return;
        }

        for (int col = 0; col < colNum; col++) {
            if(isValidQueenPosition(chessBoard, startRow, col)) {
                // DFS
                chessBoard[startRow][col] = 'Q';
                solveNQueens(chessBoard, startRow + 1);
                chessBoard[startRow][col] = '.';
            }
        }
    }

    private boolean isValidQueenPosition(char[][] chessBoard, int row, int col) {
        int colNum = chessBoard[0].length;

        for (int rowPos = 0; rowPos <= row; rowPos++) {
            for (int colPos = 0; colPos < colNum; colPos++) {
                // check same row
                if (rowPos == row && chessBoard[rowPos][colPos] == 'Q') {
                    return false;
                }

                // check same column
                if (colPos == col && chessBoard[rowPos][colPos] == 'Q') {
                    return false;
                }

                // check upper-left diagonal
                if ((col - colPos) == (row - rowPos) && chessBoard[rowPos][colPos] == 'Q') {
                    return false;
                }

                // check upper-right diagonal
                if ((colPos - col) == (row - rowPos) && chessBoard[rowPos][colPos] == 'Q') {
                    return false;
                }
            }
        }

        return true;
    }

    private void initResult() {
        result = new ArrayList<>();
    }

    private List<List<String>> getResult() {
        return result;
    }

    private void saveToResult(char[][] chessBoard) {
        result.add(convertToList(chessBoard));
    }

    private char[][] initChessBoard(int n) {
        char[][] result = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = '.';
            }
        }
        return result;
    }

    private List<String> convertToList(char[][] doubleArray) {
        List<String> result = new ArrayList<>();

        int rowNum = doubleArray.length;
        int colNum = doubleArray[0].length;

        for (int row = 0; row < rowNum; row++) {
            String rowStr = "";
            for (int col = 0; col < colNum; col++) {
                rowStr += doubleArray[row][col];
            }
            result.add(rowStr);
        }

        return result;
    }
}