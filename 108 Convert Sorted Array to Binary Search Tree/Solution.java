/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
    public TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;

        if (length == 0) return null;
        TreeNode treeRoot = sortedArrayToBST(nums, 0, length - 1);

        return treeRoot;
    }

    private TreeNode sortedArrayToBST(int[] nums, int head, int tail) {
		TreeNode treeRoot;
		
		if (head == tail) {
			treeRoot = initTreeNode(nums[head], null, null);
		}
		else if ((tail - head) == 1) {
			TreeNode treeLeft = initTreeNode(nums[head], null, null);
			treeRoot = initTreeNode(nums[tail], treeLeft, null);
		}
		//(tail - head) > 1
		else {
			int mid = (head + tail) / 2;
			TreeNode treeLeft = sortedArrayToBST(nums, head, (mid - 1));
			TreeNode treeRight = sortedArrayToBST(nums, (mid + 1), tail);
			treeRoot = initTreeNode(nums[mid], treeLeft, treeRight);
		}

		return treeRoot;
    }

    private TreeNode initTreeNode(int val, TreeNode left, TreeNode right) {
    	TreeNode treeNode = new TreeNode(val);
    	treeNode.left = left;
    	treeNode.right = right;
    	return treeNode;
    }
}