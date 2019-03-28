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
    public boolean isValidBST(TreeNode root) {
        if (root != null) {
            if (root.left != null && (root.val <= root.left.val || !isValidBST(root.left) || getMax(root.left) >= root.val)) {
                return false;
            }
            if (root.right != null && (root.val >= root.right.val || !isValidBST(root.right) || getMin(root.right) <= root.val)) {
                return false;
            }
        }
        return true;
    }

    private int getMin(TreeNode root) {
        while(root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    private int getMax(TreeNode root) {
        while(root.right != null) {
            root = root.right;
        }
        return root.val;
    }
}