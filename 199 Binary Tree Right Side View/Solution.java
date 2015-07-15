/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
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
	//retrive all the node from left to right recursively
	//update the elements in the list by level
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
		rightSideViewRecursion(list, root, 0);

        return list;
    }

    private void rightSideViewRecursion (List<Integer> list, TreeNode root, int height) {
    	if (root != null) {
    		//the number of levels that has already retrived
    		int len = list.size();

    		//this level is not retrived yet
    		if (height > (len - 1)) {
    			list.add(root.val);
    		}
    		//this level was already retrived, then update the list
    		else {
    			list.set(height, root.val);
    		}

			if (root.left != null) {
				rightSideViewRecursion(list, root.left, height + 1);
			}    

			if (root.right != null) {
				rightSideViewRecursion(list, root.right, height + 1);
			}    		
    	}
    }
}