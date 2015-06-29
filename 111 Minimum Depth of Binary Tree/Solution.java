/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
*/

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
    public int minDepth(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}
    	else {
    		return minDepthRecursion(root);
    	}
    }

    private int minDepthRecursion (TreeNode root) {
    	if (root == null) {
    		return 10000000;
    	}
    	else if (root.left == null && root.right == null) {
    		return 1;
    	}
    	else {
    		return (Math.min(minDepthRecursion(root.left), minDepthRecursion(root.right)) + 1);
    	}
    }
}