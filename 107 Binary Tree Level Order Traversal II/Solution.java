/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.


OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:
   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	int depth = depthOfTree(root);

    	for (int i = 0; i < depth; i ++) {
    		List<Integer> listTemp = new ArrayList<Integer>();
    		list.add(listTemp);
    	}

    	buildLevelOrderBottom(root, list, 0, depth);
        return list;
    }

    //recursively add every node to the according list(DFS)
    private void buildLevelOrderBottom(TreeNode root, List<List<Integer>> list, int curDepth, int depth) {
    	if (root != null) {
    		List<Integer> listTemp = list.get(depth - curDepth - 1);
			listTemp.add(root.val);

    		buildLevelOrderBottom(root.left, list, (curDepth + 1), depth);
    		buildLevelOrderBottom(root.right, list, (curDepth + 1), depth);
    	}
    }

    //get the depth of the whole tree
    private int depthOfTree (TreeNode root) {
    	if (root != null) {
    		int leftDepth = depthOfTree(root.left);
    		int rightDepth = depthOfTree(root.right);
    		return (Math.max(leftDepth, rightDepth) + 1);
    	}
    	else return 0;
    }
}