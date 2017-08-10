/*
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

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
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        postorderTraversal_NonRecursive(root, result);

        return result;
    }

    private void postorderTraversal_Recursive(TreeNode root, List<Integer> result) {
    	if (root != null) {
	    	postorderTraversal_Recursive(root.left, result);
	    	postorderTraversal_Recursive(root.right, result);
	    	result.add(root.val);
    	}
    }

    private void postorderTraversal_NonRecursive(TreeNode root, List<Integer> result) {
    	TreeNode cur;
    	TreeNode popNode;
    	Stack<TreeNode> stack = new Stack<TreeNode>();

    	if (root != null) {
    		cur = root;
    		stack.push(cur);

    		while (!stack.empty()) {
    			//searching all left child
    			while (cur.left != null) {
    				stack.push(cur.left);
    				cur = cur.left;
    			}
    			
    			//searching all left child of the right child of the current node that has no left child
    			if (cur.right != null) {
    				stack.push(cur.right);
    				cur = cur.right;
    			}
    			//handle the node has neithor left nor right child
    			else {
    				while (!stack.empty()) {
	    				popNode = stack.pop();
	    				//print the node
	    				result.add(popNode.val);
	    				if (!stack.empty()) {
		    				//get the parent node of the node
		    				cur = stack.peek();
		    				//the pop node is the left child of the parent node
		    				if (popNode == cur.left) {
		    					if (cur.right != null) {
		    						stack.push(cur.right);
		    						cur = cur.right;
		    						break;
		    					}
		    				}
		    				//the pop node is the right child of the parent node
		    				else {
		    					//keep poping elemets
		    				}
		    			}
		    		}
    			}
    		}
    	}
    }
}