class Solution {
    private static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        DisjointSets disjointSets = new DisjointSets(board);
        int rows = board.length;
        int cols = board[0].length;
        int dummyBorder = rows * cols; // We add an element dummyBorder to gather all elements connected to borders.

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                if (board[x][y] == 'O') {
                    int borderO = x * cols + y;
                    if (x == 0 || x == rows - 1 || y == 0 || y == cols - 1) {
                        disjointSets.union(dummyBorder, borderO);
                        continue;
                    }
                    for (int[] dir : directions) {
                        int nx = x + dir[0];
                        int ny = y + dir[1];
                        if (nx >= 0 && ny >= 0 && nx < rows && ny < cols && board[nx][ny] == 'O') {
                            int neighbor = nx * cols + ny;
                            disjointSets.union(borderO, neighbor);
                        }
                    }
                }
            }
        }

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                if (board[x][y] == 'O' && disjointSets.find(x * cols + y) != disjointSets.find(dummyBorder)) {
                    board[x][y] = 'X';
                }
            }
        }
    }

    class DisjointSets {
        int[] parent;

        public DisjointSets(char[][] board) {
            int rows = board.length, cols = board[0].length;
            parent = new int[rows * cols + 1];

            for (int x = 0; x < rows; x++) {
                for (int y = 0; y < cols; y++) {
                    if (board[x][y] == 'O') {
                        int id = x * cols + y;
                        parent[id] = id;
                    }
                }
            }
            parent[rows * cols] = rows * cols;
        }

        public int find(int x) {
            if (x == parent[x]) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootY] = rootX;
            }
        }
    }
}