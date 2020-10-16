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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        // special case handling
        if (root == null) return result;

        // use BFS to traverse trees by levels
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int parentLevelSize = queue.size();
        int currentLevel = 0;

        // use queue to traverse tree by levels
        while (!queue.isEmpty()) {
            List<Integer> currentLevelResult = new ArrayList<>();
            int currentLevelSize = 0;
            currentLevel++;
            for (int i = 0; i < parentLevelSize; i++) {
                TreeNode tempNode = queue.poll();
                currentLevelResult.add(tempNode.val);
                if (tempNode.left != null) {
                    queue.offer(tempNode.left);
                    currentLevelSize++;
                }
                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                    currentLevelSize++;
                }
            }
            parentLevelSize = currentLevelSize;

            // reverse the current level when needed
            if (currentLevel % 2 == 0) Collections.reverse(currentLevelResult);
            result.add(currentLevelResult);
        }

        return result;
    }
}