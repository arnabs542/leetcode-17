/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
click to show hints.

Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
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
	private Stack<TreeNode> stack = new Stack<TreeNode>();

    public void flatten(TreeNode root) {
    	TreeNode pre = null;

        if (root != null) {
        	stack.push(root);
        }

        while (!stack.empty()) {
        	TreeNode temp = stack.pop();

        	if (temp.right != null) {
        		stack.push(temp.right);
        	}
        	if (temp.left != null) {
        		stack.push(temp.left);
        	}

        	if (temp == root) {
        		pre = root;
        		pre.left = null;
        		pre.right = null;
        	}
        	else {
        		pre.right = temp;
        		temp.left = null;
        		temp.right = null;
        		pre = temp;
        	}
        }
    }
}