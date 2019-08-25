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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // specail case handling
        if(t1 == null && t2 == null) return null;

        // calculate new node value
        int newVal = 0;
        if(t1 != null) {
            if(t2 != null) {
                newVal = t1.val + t2.val;
            } else {
                newVal = t1.val;
            }
        } else {
            newVal = t2.val;
        }

        // init new node
        TreeNode newNode = new TreeNode(newVal);

        // init left and right child
        if(t1 == null) {
            newNode.left = mergeTrees(null, t2.left);
            newNode.right = mergeTrees(null, t2.right);
        } else {
            if(t2 == null) {
                newNode.left = mergeTrees(t1.left, null);
                newNode.right = mergeTrees(t1.right, null);
            } else {
                newNode.left = mergeTrees(t1.left, t2.left);
                newNode.right = mergeTrees(t1.right, t2.right);
            }
        }

        return newNode;
    }
}