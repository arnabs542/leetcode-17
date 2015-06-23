/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        levelOrderRecursion(root, 0, list);

        return list;
    }

    private void levelOrderRecursion (TreeNode root, int height, List<List<Integer>> list) {
    	if (root != null) {
    		List<Integer> listTemp;

    		int len = list.size();
    		if (len <= height) {
    			listTemp = new ArrayList<Integer>();
    			list.add(listTemp);
    		}
    		else {
    			listTemp = list.get(height);
    		}

    		listTemp.add(root.val);

    		if (root.left != null) {
    			levelOrderRecursion(root.left, height + 1, list);
    		}
    		
    		if (root.right != null) {
    			levelOrderRecursion(root.right, height + 1, list);
    		}
    	}
    }
}