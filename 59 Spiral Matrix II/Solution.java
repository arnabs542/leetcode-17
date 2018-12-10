class Solution {
    // right, down, left, up
    private static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int placeHolder = 0;

        initMatrix(result, placeHolder);

        int curDirId = 0;
        int[] curPos = {0, 0};
        for(int i = 1; i <= n * n; i++) {
            setCurPos(result, curPos, i);
            curDirId = getDirection(result, placeHolder, curPos, curDirId);
            curPos = getNextPos(curPos, curDirId);
        }

        return result;
    }

    private void initMatrix(int[][] result, int placeHolder) {
        int n = result.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                result[i][j] = placeHolder;
            }
        }
    }

    private void setCurPos(int[][] result, int[] curPos, int i) {
        result[curPos[0]][curPos[1]] = i;
    }

    private int getDirection(int[][] result, int placeHolder, int[] curPos, int curDirId) {
        int n = result.length;
        int[] curDir = directions[curDirId];

        int newX = curPos[0] + curDir[0];
        int newY = curPos[1] + curDir[1];

        if(newX >= n || newX < 0 || newY >= n || newY < 0) {
            // check if next pos is valid pos
            return (curDirId + 1) % 4;
        } else if (result[newX][newY] != placeHolder) {
            // check if next pos is not occupied
            return (curDirId + 1) % 4;
        } else {
            return curDirId;
        }
    }

    private int[] getNextPos(int[] curPos, int curDirId) {
        int[] curDir = directions[curDirId];
        int[] newPos = new int[2];
        for(int i = 0; i < 2; i++) {
            newPos[i] = curPos[i] + curDir[i];
        }
        return newPos;
    }
}