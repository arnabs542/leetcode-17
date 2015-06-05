/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
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

//Reference: http://www.programcreek.com/2013/02/leetcode-balanced-binary-tree-java/

public class Solution {
	//This solution originates from the reference 
	//we can get the answer of the sulution during the caculation of the height of the tree
	public boolean isBalanced(TreeNode root) {
		if (root == null) return true;
 
		if (getHeight(root) == -1) return false;
 
		return true;
	}
 
	public int getHeight(TreeNode root) {
		if (root == null) return 0;
 
		int left = getHeight(root.left);
		int right = getHeight(root.right);
 
		if (left == -1 || right == -1) return -1;
 
		if (Math.abs(left - right) > 1) return -1;
 
		return Math.max(left, right) + 1;
 
	}

	//This is my initial solution, which is a bad solution having error of StackOverflowError
	//It is not necessary to calculate the height value for every node, it cost too much memory
    public boolean isBalanced_InitBadSolution(TreeNode root) {
    	if (root == null) return true;
    	else if (isBalanced(root.left)) {
    		if (isBalanced(root.right)) {
    			if (Math.abs(height(root.left) - height(root.right)) <= 1) {
    				return true;
    			}
    		}
    	} 
    	return false;
    }

    private int height(TreeNode root) {
    	if (root == null) return 0;
    	else return Math.max(height(root.left), height(root.right)) + 1;
    }
}