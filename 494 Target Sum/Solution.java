class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays_recur(nums, 0, nums.length - 1, S);
    }

    public int findTargetSumWays_recur(int[] nums, int start, int end, int S) {
        int len = end - start + 1;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            if (nums[start] == S && nums[start] == S * (-1)) return 2;
            else if (nums[start] == S || nums[start] == S * (-1)) return 1;
            else return 0;
        } else {
            int lastVal = nums[end];
            return findTargetSumWays_recur(nums, start, end - 1, S + lastVal) + findTargetSumWays_recur(nums, start, end - 1, S - lastVal);
        }
    }
}
