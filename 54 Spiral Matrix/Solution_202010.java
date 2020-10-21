class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        // special case handling
        if (matrix == null || matrix.length == 0) return result;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] visited = new int[rows][cols];

        int[] curPosition = new int[]{0, 0};
        int curDirection = 0;

        result.add(matrix[0][0]);
        visited[0][0] = 1;

        while (result.size() < rows * cols) {
            // find the next position to traverse
            int[] nextPosition = getNextPosition(curPosition, curDirection, visited);
            if (nextPosition == null) {
                // invalid position with current direction, change the direction
                curDirection = (curDirection + 1) % 4;
            } else {
                // find a new valid position
                curPosition = nextPosition;
                result.add(matrix[curPosition[0]][curPosition[1]]);
                visited[curPosition[0]][curPosition[1]] = 1;
            }
        }

        return result;
    }

    private int[] getNextPosition(int[] curPosition, int curDirection, int[][] visited) {
        // special case handling
        if (visited == null || curPosition == null) return null;

        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int rows = visited.length;
        int cols = visited[0].length;

        // calculate next postion
        int rowNext = curPosition[0] + directions[curDirection][0];
        int colNext = curPosition[1] + directions[curDirection][1];

        // check if next postion valid
        if (rowNext >= 0 && rowNext < rows && colNext >= 0 && colNext < cols && visited[rowNext][colNext] == 0) {
            return new int[]{rowNext, colNext};
        } else {
            return null;
        }
    }
}