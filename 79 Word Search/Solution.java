// reference: http://www.cnblogs.com/yrbbest/p/4437124.html
// reference: http://bangbingsyb.blogspot.ca/2014/11/leetcode-word-search.html
public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || board.length == 0) return false;
        int rowNum = board.length, colNum = board[0].length;
        boolean[][] visited = new boolean[rowNum][colNum];
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (exist(board, visited, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, boolean[][] visited, String word, int i, int j, int pos) {
        if (pos == word.length()) return true;
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1) return false;
        if (visited[i][j] || board[i][j] != word.charAt(pos)) return false;
        visited[i][j] = true;

        if (exist(board, visited, word, i - 1, j, pos + 1)
            || exist(board, visited, word, i + 1, j, pos + 1)
            || exist(board, visited, word, i, j - 1, pos + 1)
            || exist(board, visited, word, i, j + 1, pos + 1)) return true;

        visited[i][j] = false;
        return false;
    }
}
