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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        List<String> parents = new ArrayList<>();
        dfs(root, parents, paths);
        return paths;
    }

    private void dfs(TreeNode root, List<String> parents, List<String> paths) {
        // null node
        if (root == null) return;

        // leaf node
        if (root.left == null && root.right == null) {
            String path = String.join("->", parents);
            if (parents.size() > 0) path += "->";
            path += root.val;
            paths.add(path);
        } else {
            // non-leaf node
            parents.add(String.valueOf(root.val));
            dfs(root.left, parents, paths);
            dfs(root.right, parents, paths);
            parents.remove(parents.size() - 1);
        }

    }
}