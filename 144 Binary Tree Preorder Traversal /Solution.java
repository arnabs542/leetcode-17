/*
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
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

//Solution: http://fisherlei.blogspot.ca/2013/11/leetcode-binary-tree-preorder-traversal.html
//Solution: http://blog.csdn.net/linhuanmars/article/details/21428647

public class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();

		TreeNode temp = root;
		
		while (temp != null) {
			result.add(temp.val);
			stack.push(temp);

			while (temp.left != null) {
				temp = temp.left;
				result.add(temp.val);
				stack.push(temp);
			}

			temp = stack.pop();

			while (temp.right == null && temp != null && !stack.empty()) {
				temp = stack.pop();
			}

			temp = temp.right;
		}

		return result;
	}

    public List<Integer> preorderTraversal_Recursive(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root != null) {
        	result.add(root.val);
	        if (root.left != null) {
	        	result.addAll(preorderTraversal(root.left));
	        }
	        if (root.right != null) {
	        	result.addAll(preorderTraversal(root.right));
	        }
        }

        return result;
    }
}