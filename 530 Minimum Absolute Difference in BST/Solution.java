/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int MAX = 99999;
    private int preNode = (-1) * MAX;
    private int curNode = MAX;
    private int minDiff;

    public int getMinimumDifference(TreeNode root) {
        minDiff = MAX;
        traverseBiTree(root);
        return minDiff;
    }

    private void traverseBiTree(TreeNode root) {
        if (root != null) {
            traverseBiTree(root.left);
            curNode = root.val;
            minDiff = Math.min(minDiff, curNode - preNode);
            preNode = curNode;
            traverseBiTree(root.right);
        }
    }
}
