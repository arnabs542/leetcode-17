/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
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
    public int kthSmallest(TreeNode root, int k) {
    	int result = 0;

    	if (root != null) {
    		int left = countNodes(root.left);
    		if (k == (left + 1)) {
    			result = root.val;
    		}
    		else if (k > (left + 1)) {
    			result = kthSmallest(root.right, k - left - 1);
    		}
    		//k < (left + 1)
    		else {
    			result = kthSmallest(root.left, k);
    		}
    	}

    	return result;
    }

    private int countNodes (TreeNode root) {
    	int nodes = 0;

    	if (root != null) {
    		nodes = countNodes(root.left) + countNodes(root.right) + 1;
    	}

    	return nodes;
    }
}