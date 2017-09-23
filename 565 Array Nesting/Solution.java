class Solution {
    int[] visitedPos;

    public int arrayNesting(int[] nums) {
        visitedPos = new int[nums.length];
        for (int i = 0; i < nums.length; i++) visitedPos[i] = 0;

        int maxSetSize = 0;

        for (int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            if (visitedPos[curNum] == 0 ) {
              int curSetSize = this.getCurPosSetSize(i, nums);
              if (curSetSize > maxSetSize) {
                  maxSetSize = curSetSize;
              }
            }
        }

        return maxSetSize;
    }

    private int getCurPosSetSize(int pos, int[] nums) {
        int curPosSetSize = 0;

        int curPos = pos;
        while (curPos != pos || curPosSetSize == 0) {
            visitedPos[curPos] = 1;
            curPos = nums[curPos];
            curPosSetSize++;
        }

        return curPosSetSize;
    }
}
