class Solution {
    // we have four orders: right, down, left, up
    // we should circle the directions
    private final int[][] directionOrder = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<Integer> spiralOrder(int[][] matrix) {
        // init result
        List<Integer> result = new ArrayList<>();

        // validate input
        if(matrix == null) return result;
        int rows = matrix.length;
        if(rows == 0) return result;
        int cols = matrix[0].length;
        if(cols == 0) return result;

        Set<String> visited = new HashSet<>();
        int direction = 0;
        int[] curElement = {0, 0};
        String curElementStr = getStringFromPosition(curElement[0], curElement[1]);

        while(!visited.contains(curElementStr) && isValidEle(curElement, rows, cols)) {
            result.add(matrix[curElement[0]][curElement[1]]);
            visited.add(curElementStr);
            // try next element in the same direction
            int[] nextEle = getNextEle(curElement, direction);
            String nextEleStr = getStringFromPosition(nextEle[0], nextEle[1]);
            if(visited.contains(nextEleStr) || !isValidEle(nextEle, rows, cols)) {
                // else try next element in the next direction
                direction = (direction + 1) % 4;
                nextEle = getNextEle(curElement, direction);
                nextEleStr = getStringFromPosition(nextEle[0], nextEle[1]);
            }
            curElement = nextEle;
            curElementStr = getStringFromPosition(curElement[0], curElement[1]);
        }

        return result;
    }

    private String getStringFromPosition(int x, int y) {
        return Integer.toString(x) + "," + Integer.toString(y);
    }

    private int[] getNextEle(int[] curElement, int direction) {
        int[] nextElement = new int[2];
        nextElement[0] = curElement[0] + this.directionOrder[direction][0];
        nextElement[1] = curElement[1] + this.directionOrder[direction][1];
        return nextElement;
    }

    private boolean isValidEle(int[] curElement, int rows, int cols) {
        if(curElement[0] < 0 || curElement[0] >= rows) {
            return false;
        }
        if(curElement[1] < 0 || curElement[1] >= cols) {
            return false;
        }
        return true;
    }
}