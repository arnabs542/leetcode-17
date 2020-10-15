/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // use BFS to traverse the tree
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> levels = new ArrayList<>();

        // special case handling
        if (root == null) return levels;

        queue.add(root);
        int parentLevelNodes = 1;

        while (!queue.isEmpty()) {
            // traverse nodes by levels
            List<Integer> currentLevel = new ArrayList<>();
            int currentLevelNodes = 0;

            // traverse all nodes of the current level
            for (int i = 0; i < parentLevelNodes; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                    currentLevelNodes++;
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                    currentLevelNodes++;
                }
            }
            parentLevelNodes = currentLevelNodes;
            levels.add(currentLevel);
        }

        return levels;
    }
}