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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return this._constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode _constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start > end) return null;

        int maxNumPosition = this.getMaxNumPosition(nums, start, end);
        TreeNode leftChild = this._constructMaximumBinaryTree(nums, start, maxNumPosition - 1);
        TreeNode rightChild = this._constructMaximumBinaryTree(nums, maxNumPosition + 1, end);
        TreeNode root = new TreeNode(nums[maxNumPosition]);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }

    private int getMaxNumPosition(int[] nums, int start, int end) {
        int maxNumPosition = start;
        int max = nums[maxNumPosition];
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxNumPosition = i;
            }
        }
        return maxNumPosition;
    }
}
