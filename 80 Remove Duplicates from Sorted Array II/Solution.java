class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;

        if (len <= 2) return len;

        // update array
        int newArrayPos = 1;
        int prevNum = nums[0];
        int curNumCount = 1;
        for (int i = 1; i < len; i++) {
            // update statistics
            int curNum = nums[i];
            if (curNum == prevNum) {
                curNumCount++;
            } else {
                curNumCount = 1;
                prevNum = curNum;
            }

            // in-place update
            if (newArrayPos != i) {
                nums[newArrayPos] = nums[i];
            }

            // update new array position info
            if (curNumCount <= 2) {
                newArrayPos++;
            }
        }

        return newArrayPos;
    }
}