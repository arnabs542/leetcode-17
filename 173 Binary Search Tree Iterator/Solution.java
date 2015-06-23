/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
	private TreeNode root;
	private TreeNode curNode;
	private Queue<Integer> queue = new LinkedList<Integer>();

    public BSTIterator(TreeNode root) {
        this.root = root;
        initQueue(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (queue.peek() != null) {
        	return true;
        }
        else {
        	return false;
        }
    }

    /** @return the next smallest number */
    public int next() {
        return queue.remove();
    }

    private void initQueue (TreeNode root) {
    	if (root != null) {
    		if (root.left != null) {
    			initQueue(root.left);
    		}

    		queue.add(root.val);

    		if (root.right != null) {
    			initQueue(root.right);
    		}
    	}
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */