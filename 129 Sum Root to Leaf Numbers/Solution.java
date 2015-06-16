/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
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
	private int sumTotal;

	//DFS(Depth First Search)
	public int sumNumbers (TreeNode root) {
		sumTotal = 0;
		DFS(root, 0);
		return sumTotal;
	}

	public void DFS (TreeNode root, int sum) {
		if (root != null) {
			int t = sum * 10 + root.val;
			if (root.left != null || root.right != null) {
				DFS(root.left, t);
				DFS(root.right, t);
			}
			else {
				sumTotal += t;
			}
		}
	}

	//Wrong answer with wrong thought. But we need pay attention to this wrong thought to avoid it.
    public int sumNumbers_Wrong (TreeNode root) {
        Values v = sum (root);
        return v.getSum();
    }

    private Values sum (TreeNode root) {
    	if (root != null) {
    		Values vLeft = sum(root.left);
    		Values vRight = sum(root.right);
    		int leftSum = vLeft.getSum();
    		int rightSum = vRight.getSum();
    		int leftHeight = vLeft.getHeight();
    		int rightHeight = vRight.getHeight();

    		int sumR = leftSum + rightSum + root.val * (pow10(leftHeight) + pow10(rightHeight));
    		if (sumR == 0) {
    			sumR = root.val;
    		}
    		int height = Math.max(leftHeight, rightHeight) + 1;

    		return new Values(sumR, height);
    	}
    	else {
    		return new Values(0, 0);
    	}
    }

    private int pow10 (int n) {
    	if (n == 0) return 0;

    	int result = 1;
    	for (int i = 0; i < n; i ++) {
    		result *= 10;
    	}
    	return result;
    }

    private class Values {
    	private int sum;
    	private int height;

    	public Values(int sum, int height) {
    		this.sum = sum;
    		this.height = height;
    	}

    	public int getSum () {
    		return this.sum;
    	}

    	public int getHeight () {
    		return this.height;
    	}
    }
}