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
    public List<List<String>> printTree(TreeNode root) {
        int m = getHeight(root);
        int n = (int) Math.pow(2.0, (double)(m)) - 1;
        String DEFAULT_VALUE = "";

        // init the double list result set
        List<List<String>> result = initResult(m, n, DEFAULT_VALUE);

        // fill in the print result
        traverseTree(root, result, 0, n / 2, m);

        return result;
    }

    private List<List<String>> initResult(int m, int n, String defaultValue) {
        List<List<String>> result = new ArrayList<List<String>>();
        for (int i = 0; i < m; i++) {
            List<String> row = new ArrayList<String>();
            for (int j = 0; j < n; j++) {
                row.add(defaultValue);
            }
            result.add(row);
        }
        return result;
    }

    // fill in the print result
    private void traverseTree(TreeNode root, List<List<String>> result, int row, int col, int height) {
        if (root != null) {
            result.get(row).set(col, Integer.toString(root.val));
            int diffDistance = (int) Math.pow(2.0, (double)(height - 2 - row));
            traverseTree(root.left, result, row + 1, col - diffDistance, height);
            traverseTree(root.right, result, row + 1, col + diffDistance, height);
        }
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(this.getHeight(root.left), this.getHeight(root.right)) + 1;
    }
}
