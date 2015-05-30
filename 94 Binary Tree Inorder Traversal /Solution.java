/*
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?

confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
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
	public List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> list = new ArrayList<Integer>();

		TreeNode temp = root;
		stack.push(temp);

		while (temp != null) {
			while (temp.left != null) {
				stack.push(temp.left);
				temp = temp.left;
			}

			while (!stack.empty()) {
				temp = stack.pop();
				list.add(temp.val);

				if (temp.right != null) {
					stack.push(temp.right);
					temp = temp.right;
					break;
				}				
			}

			if (stack.empty()) {
				temp = null;
			}
		}

		return list;
	}

    public List<Integer> inorderTraversal_Recurcively(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        inorderTraversalList(root, list);

        return list;
    }

    private void inorderTraversalList (TreeNode root, List<Integer> list) {
    	if (root != null) {
    		inorderTraversalList(root.left, list);
    		list.add(root.val);
    		inorderTraversalList(root.right, list);
    	}

    }
}