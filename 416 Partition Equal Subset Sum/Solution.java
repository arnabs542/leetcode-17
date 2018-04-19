// This is the Original solution, which was on the right route
// However it did not pass the OJ (Online Judge)
//it is because that the algorithm needs to be optimized
class Solution_Original {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        if (sum % 2 == 0) {
            int sumTarget = sum / 2;
            return canSumTo(nums, 0, nums.length - 1, sumTarget);
        } else {
            return false;
        }
    }

    private boolean canSumTo(int[] nums, int start, int end, int sumTarget) {
        if (start == end) {
            return nums[start] == sumTarget;
        } else if (start > end) {
            return false;
        } else {
            return canSumTo(nums, start, end - 1, sumTarget) || canSumTo(nums, start, end - 1, sumTarget - nums[end]);
        }
    }
}

// reference: http://www.cnblogs.com/grandyang/p/5951422.html
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }

        if (sum % 2 != 0) return false;

        int sumTarget = sum / 2;
        return canSumTo(nums, sumTarget);
    }

    // use DP method
    private boolean canSumTo(int[] nums, int sumTarget) {
        // dp[i] means array nums can sum to i
        boolean[] dp = new boolean[sumTarget + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            for (int j = sumTarget; j >= currentNum; j--) {
                dp[j] = dp[j] || dp[j - currentNum];
            }
        }
        return dp[sumTarget];
    }
}