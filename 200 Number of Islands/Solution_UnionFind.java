public class Solution {
    class GridPosition {
        public int row;
        public int col;
        public int rows;
        public int cols;

        public GridPosition (int rows, int cols, int row, int col) {
            this.rows = rows;
            this.cols = cols;
            this.row = row;
            this.col = col;
        }

        public int getPosition() {
            return this.row * this.cols + this.col;
        }

        public GridPosition getRightPosition() {
            if (this.col < cols - 1) {
                return new GridPosition(this.rows, this. cols, this.row, this.col + 1);
            } else {
                return null;
            }
        }

        public GridPosition getDownPosition() {
            if (this.row < rows - 1) {
                return new GridPosition(this.rows, this. cols, this.row + 1, this.col);
            } else {
                return null;
            }
        }

        public boolean equalsTo(GridPosition o) {
            return o.rows == this.rows &&
                    o.cols == this.cols &&
                    o.row == this.row &&
                    o.col == this.col;
        }
    }

    class UnionFind {
        private GridPosition[] parent;

        public UnionFind(char[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;
            int totalLength = rows * cols;

            // init union find
            this.parent = new GridPosition[totalLength];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    GridPosition tempPosition = new GridPosition(rows, cols, i, j);
                    parent[tempPosition.getPosition()] = tempPosition;
                }
            }
        }

        public void union(GridPosition pos1, GridPosition pos2) {
            GridPosition pos1Root = this.find(pos1);
            GridPosition pos2Root = this.find(pos2);
            parent[pos2Root.getPosition()] = pos1Root;
        }

        public GridPosition find(GridPosition pos) {
            GridPosition currentGridPosition = pos;
            while (!parent[currentGridPosition.getPosition()].equalsTo(currentGridPosition)) {
                currentGridPosition = parent[currentGridPosition.getPosition()];
            }
            return currentGridPosition;
        }
    }

    // use union find to group islands
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        // init union find
        UnionFind unionFind = new UnionFind(grid);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    GridPosition currentPosition = new GridPosition(rows, cols, i, j);
                    // check right grid point
                    GridPosition rightPosition = currentPosition.getRightPosition();
                    if (rightPosition != null && grid[rightPosition.row][rightPosition.col] == '1')
                        unionFind.union(currentPosition, rightPosition);
                    // check down grid point
                    GridPosition downPosition = currentPosition.getDownPosition();
                    if (downPosition != null && grid[downPosition.row][downPosition.col] == '1')
                        unionFind.union(currentPosition, downPosition);
                }
            }
        }

        // check results
        int numberOfIsland = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    GridPosition currentPosition = new GridPosition(rows, cols, i, j);
                    // check union find parent
                    if (unionFind.find(currentPosition).equalsTo(currentPosition))
                        numberOfIsland++;
                }
            }
        }

        return numberOfIsland;
    }
}