/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

Subscribe to see which companies asked this question
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
    public TreeNode buildTree (int[] preorder, int[] inorder) {
    	if (preorder.length == 0) {
    		return null;
    	}
        return buildTreeRecursive(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeRecursive (int[] preorder, int startPre, int endPre, 
    	int[] inorder, int startIn, int endIn) {
    	if (startPre <= endPre) {
	    	int rootVal = preorder[startPre];
	    	TreeNode root = new TreeNode(rootVal);

	    	int rootPosition = getPosition(inorder, startIn, endIn, rootVal);
	    	int leftNodes = rootPosition - startIn;
	    	int rightNodes = endIn - rootPosition;

	    	TreeNode leftChild = buildTreeRecursive(preorder, startPre + 1, startPre + leftNodes, 
	    		inorder, startIn , rootPosition - 1);
	    	root.left = leftChild;
	    	
	    	TreeNode rightChild = buildTreeRecursive(preorder, endPre - rightNodes + 1, endPre, 
	    		inorder, rootPosition + 1 , endIn);
	    	root.right = rightChild;

	    	return root;
	    }
	    return null;
    }

    private int getPosition(int[] inorder, int startIn, int endIn, int rootVal) {
    	for (int i = startIn; i <= endIn; i ++) {
    		if (inorder[i] == rootVal) {
    			return i;
    		}
    	}

    	return 0;
    }
}