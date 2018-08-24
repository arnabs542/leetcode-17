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
    private List<List<Integer>> result = null;

    // use DFS, depth first search
    // it is actually recursion as well, as tree is recursively defined, it is easy to use recursion to solve the problem
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();

        List<Integer> currentPath = new ArrayList<>();
        dfs(root, sum, currentPath);

        return result;
    }

    private void dfs(TreeNode root, int sum, List<Integer> currentPath) {
        if (root != null) {
            int currentVal = root.val;
            int newSum = sum - currentVal;
            currentPath.add(currentVal);

            if (newSum == 0 && root.left == null && root.right == null) {
                result.add(deepCopyList(currentPath));
            } else {
                dfs(root.left, newSum, currentPath);
                dfs(root.right, newSum, currentPath);
            }

            currentPath.remove(currentPath.size() - 1);
        }
    }

    private List<Integer> deepCopyList(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        for (int i: list) {
            newList.add(i);
        }
        return newList;
    }
}