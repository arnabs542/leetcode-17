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
    private class ResultSet {
        private int val;
        private int height;

        ResultSet(int val, int height) {
            this.val = val;
            this.height = height;
        }

        public int getVal() {
            return this.val;
        }

        public int getHeight() {
            return this.height;
        }
    }

    public int findBottomLeftValue(TreeNode root) {
        return this._findBottomLeftValue(root).getVal();
    }

    private ResultSet _findBottomLeftValue(TreeNode root) {
        if (root != null) {
            ResultSet resultSetLeft = _findBottomLeftValue(root.left);
            ResultSet resultSetRight = _findBottomLeftValue(root.right);

            if (resultSetLeft.getHeight() == 0 && resultSetRight.getHeight() == 0) {
                return new ResultSet(root.val, 1);
              } else if (resultSetLeft.getHeight() >= resultSetRight.getHeight()) {
                return new ResultSet(resultSetLeft.getVal(), resultSetLeft.getHeight() + 1);
            } else {
                return new ResultSet(resultSetRight.getVal(), resultSetRight.getHeight() + 1);
            }
        } else {
            return new ResultSet(0, 0);
        }
    }
}
