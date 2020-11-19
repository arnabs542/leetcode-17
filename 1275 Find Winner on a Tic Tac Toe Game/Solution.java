class Solution {
    // assume moves input is always valid, skip input validation
    public String tictactoe(int[][] moves) {
        char[][] board = constructBoard(moves);
        String winner = checkWinner(board);
        int numberOfMoves = moves.length;
        if (winner.equals("Draw") && numberOfMoves < 9) {
            return "Pending";
        } else {
            return winner;
        }
    }

    private char[][] constructBoard(int[][] moves) {
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        int moveNumber = 1;
        for(int i = 0; i < moves.length; i++) {
            char charToFill = (moveNumber % 2 == 1) ? 'A' : 'B';
            board[moves[i][0]][moves[i][1]] = charToFill;
            moveNumber++;
        }
        return board;
    }

    private String checkWinner(char[][] board) {
        // check rows
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == board[row][1] &&
                board[row][1] == board[row][2] &&
                board[row][0] != ' ')
                return String.valueOf(board[row][0]);
        }

        // check colums
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == board[1][col] &&
                board[1][col] == board[2][col] &&
                board[0][col] != ' ')
                return String.valueOf(board[0][col]);
        }

        // check diagonals
        if (board[0][0] == board[1][1] &&
            board[1][1] == board[2][2] &&
            board[0][0] != ' ')
                return String.valueOf(board[0][0]);
        if (board[2][0] == board[1][1] &&
            board[1][1] == board[0][2] &&
            board[2][0] != ' ')
                return String.valueOf(board[2][0]);

        return "Draw";
    }
}