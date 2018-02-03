class Solution {
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        if (len == 0) return -1;
        if (len == 1) return 0;
        int pos = 0;
        int leftSum = 0;
        int rightSum = 0;

        // init rightSum
        for (int i = pos + 1; i < len; i++) {
            rightSum += nums[i];
        }

        if (leftSum == rightSum) return pos;

        // find the pivot index that leftSum = rightSum
        for (pos = 1; pos < len; pos++) {
            leftSum += nums[pos - 1];
            rightSum -= nums[pos];
            if (leftSum == rightSum) return pos;
        }

        // did not find the index
        return -1;
    }
}
