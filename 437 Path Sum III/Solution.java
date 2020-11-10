/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // we can also use HashMap to store prefix sums to calculate sums of paths of all paths to leaves (*)
    // see https://leetcode.com/problems/path-sum-iii/discuss/91878/17-ms-O(n)-java-Prefix-sum-method
    public int pathSum(TreeNode root, int sum) {
        return pathSum_Recursion(root, sum, true) + pathSum_Recursion(root, sum, false);
    }

    // TODO: add cache for performance optimization
    private int pathSum_Recursion(TreeNode root, int sum, boolean withRoot) {
        if (root == null) return 0;

        if (withRoot) {
            int currentPath = (sum == root.val) ? 1 : 0;
            int pathSumLeft = pathSum_Recursion(root.left, sum - root.val, true);
            int pathSumRight = pathSum_Recursion(root.right, sum - root.val, true);
            return currentPath + pathSumLeft + pathSumRight;
        } else {
            int pathSumLeft = pathSum_Recursion(root.left, sum, true) + pathSum_Recursion(root.left, sum, false);
            int pathSumRight = pathSum_Recursion(root.right, sum, true) + pathSum_Recursion(root.right, sum, false);
            return pathSumLeft + pathSumRight;
        }
    }

    // TODO: currently wrong, need to correct calculating duplicate cases
    private int pathSum_dfs(TreeNode root, int sum) {
        int[] count = new int[]{0};
        dfs(root, 0, sum, count, false);
        return count[0];
    }

    private void dfs(TreeNode root, int currentSum, int targetSum, int[] count, boolean parentInCurrentSum) {
        // special case handling
        if (root == null || count == null) return;

        // recursively check children cases with/without current node
        // with current node in path
        if (parentInCurrentSum) {
            // get one result
            if ((currentSum + root.val) == targetSum) count[0]++;
            dfs(root.left, currentSum + root.val, targetSum, count, true);
            dfs(root.right, currentSum + root.val, targetSum, count, true);
        }
        // with current node in path as the first node
        if (root.val == targetSum) count[0]++;
        dfs(root.left, root.val, targetSum, count, true);
        dfs(root.right, root.val, targetSum, count, true);
        // without current node in path
        dfs(root.left, 0, targetSum, count, false);
        dfs(root.right, 0, targetSum, count, false);
    }
}