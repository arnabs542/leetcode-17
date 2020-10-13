class Solution {
    // dfs to loop through all possible cases
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // special case handling
        if (nums == null || nums.length == 0) return false;
        if (k == 1) return true;

        // calculate total sum and target group sum
        int numsSum = 0;
        for (int num: nums)
            numsSum += num;
        if (numsSum % k != 0)
            return false;
        int targetGroupSum = numsSum / k;

        // dfs
        boolean[] canPartition = new boolean[1];
        int[] visited = new int[nums.length];
        dfs(nums, visited, k, targetGroupSum, 0, 0, 0, canPartition);

        return canPartition[0];
    }

    // use dfs to loop through possible case group by group with first element of the sub-group
    private void dfs(
        int[] nums,
        int[] visited,
        int groupsNeeded,
        int targetSum,
        int currentSumStart,
        int currentSum,
        int currentIdx,
        boolean[] canPartition) {
            // invalid case
            if (currentSumStart >= nums.length
            	|| currentIdx >= nums.length
            	|| currentSum > targetSum) return;

            // check recursively
            if (visited[currentIdx] == 0) {
                visited[currentIdx] = 1;

                int currentNum = nums[currentIdx];
                if ((currentSum + currentNum) == targetSum) {
                    // complete one group
                    if (groupsNeeded == 1) {
                        // find a solution
                        canPartition[0] = true;
                        return;
                    } else {
                        // find the next start number
                        for (int i = currentSumStart + 1; i < nums.length; i++) {
                            if (visited[i] == 0) {
                                dfs(nums, visited, groupsNeeded - 1, targetSum, i, 0, i, canPartition);
                                break;
                            }
                        }
                    }
                } else if ((currentSum + currentNum) < targetSum) {
                    // check next number for current group
                    for (int i = currentIdx + 1; i < nums.length; i++) {
                        if (visited[i] == 0 && (currentSum + currentNum + nums[i]) <= targetSum)
                            dfs(nums, visited, groupsNeeded, targetSum, currentSumStart, currentSum + currentNum, i, canPartition);
                    }
                }

                visited[currentIdx] = 0;
            }
    }
}