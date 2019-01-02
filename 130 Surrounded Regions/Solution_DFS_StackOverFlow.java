class Solution {
    class Cell extends Object{
        public int x;
        public int y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Cell) {
                Cell tempCell = (Cell)obj;
                return this.x == tempCell.x && this.y == tempCell.y;
            }
            return false;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 31 * hash + this.x;
            hash = 31 * hash + this.y;
            return hash;
        }
    }

    public void solve(char[][] board) {
        if(board == null) return;

        Set<Cell> visited = new HashSet<Cell>(); // record all 'O' cells that are visited
        int row = board.length;
        if(row == 0) return; // handle invalid input
        int col = board[0].length;

        // loop through all cells in the borad
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                Cell cell = new Cell(i, j);
                if(getVal(board, cell) == 'O' && !visited.contains(cell)) {
                    // find all connected cell of the current 'O' that has not been visited
                    Set<Cell> connectedCells = dfs(board, cell, visited);
                    if(!anyCellOnBorder(board, connectedCells)) {
                        // if none of 'O' on the border, flip all 'O'
                        flip(board, connectedCells);
                    }
                }
            }
        }
    }

    public Set<Cell> dfs(char[][] board, Cell cell, Set<Cell> visited) {
        Set<Cell> result = new HashSet<Cell>();

        visited.add(cell);
        if(getVal(board, cell) == 'O') {
            result.add(cell);
            // try up cell
            Cell upCell = new Cell(cell.x, cell.y - 1);
            if(isValidCell(board, upCell) && getVal(board, upCell) == 'O' && !visited.contains(upCell)) {
                result.addAll(dfs(board, upCell, visited));
            }

            // try down cell
            Cell downCell = new Cell(cell.x, cell.y + 1);
            if(isValidCell(board, downCell) && getVal(board, downCell) == 'O' && !visited.contains(downCell)) {
                result.addAll(dfs(board, downCell, visited));
            }

            // try left cell
            Cell leftCell = new Cell(cell.x - 1, cell.y);
            if(isValidCell(board, leftCell) && getVal(board, leftCell) == 'O' && !visited.contains(leftCell)) {
                result.addAll(dfs(board, leftCell, visited));
            }

            // try right cell
            Cell rightCell = new Cell(cell.x + 1, cell.y);
            if(isValidCell(board, rightCell) && getVal(board, rightCell) == 'O' && !visited.contains(rightCell)) {
                result.addAll(dfs(board, rightCell, visited));
            }
        }
        return result;
    }

    private boolean isValidCell(char[][] board, Cell cell) {
        if(cell.x < 0 || cell.x >= board.length) return false;
        if(cell.y < 0 || cell.y >= board[0].length) return false;
        return true;
    }

    private char getVal(char[][] board, Cell cell) {
        return board[cell.x][cell.y];
    }

    private void setVal(char[][] board, Cell cell, char val) {
        board[cell.x][cell.y] = val;
    }

    private boolean anyCellOnBorder(char[][] board, Set<Cell> cells) {
        for(Cell cell: cells) {
            if(isOnBorder(board, cell)) {
                return true;
            }
        }
        return false;
    }

    private boolean isOnBorder(char[][] board, Cell cell) {
        return (cell.x == 0 || cell.y == 0 || cell.x == (board.length - 1) || cell.y == (board[0].length - 1));
    }

    private void flip(char[][] board, Set<Cell> cells) {
        for(Cell cell: cells) {
            setVal(board, cell, 'X');
        }
    }
}