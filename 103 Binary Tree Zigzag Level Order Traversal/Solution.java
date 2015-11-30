/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
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

	// reference: http://bangbingsyb.blogspot.ca/2014/11/leetcode-binary-tree-zigzag-level-order.html
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	// a queue that stores the tree nodes of the current level
        Queue<TreeNode> curLevel = new LinkedList<TreeNode>();
        // a queue that stores the tree nodes of the next level
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) {
        	return result;
        }

        // record the current level number
        int levelCounter = 0;
        TreeNode temp;

        curLevel.offer(root);

        while (curLevel.peek() != null) {
        	List<Integer> curLevelResult = new ArrayList<Integer>();
        	levelCounter ++;

        	// put all the left and right children of the nodes in the curLevel queue
        	// into the nextLevel queue
        	while ((temp = curLevel.poll()) != null) {
        		curLevelResult.add(temp.val);

        		if (temp.left != null) {
        			nextLevel.offer(temp.left);
        		}
        		if (temp.right != null) {
        			nextLevel.offer(temp.right);
        		}
        	}

        	if (levelCounter % 2 == 0) {
        		Collections.reverse(curLevelResult);
        	}

        	result.add(curLevelResult);

        	// put all the nodes in the nextLevel queue into the curLevel queue
        	while ((temp = nextLevel.poll()) != null) {
        		curLevel.offer(temp);
        	}
        }

        return result;
    }
}