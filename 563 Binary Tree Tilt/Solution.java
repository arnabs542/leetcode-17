/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return findTilt(root.left) + findTilt(root.right) + Math.abs(this.getSum(root.left) - this.getSum(root.right));
        }
    }

    private static int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return getSum(root.left) + getSum(root.right) + root.val;
        }
    }
}
