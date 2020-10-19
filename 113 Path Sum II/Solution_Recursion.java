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
    // we could use DFS/Recursion to solve the issue
    // this file focuses on the recursion version
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();

        // special case handling
        if (root == null) return result;

        // calculate path recursively
        if (root.left == null && root.right == null) {
            // leaf node
            if (root.val == sum) {
                List<Integer> newPath = new ArrayList<>();
                newPath.add(root.val);
                result.add(newPath);
            }
            return result;
        } else {
            // none leaf node
            List<Integer> tempNewPath = new ArrayList();
            tempNewPath.add(root.val);

            // calculate left path recursively
            List<List<Integer>> subLeftResult = pathSum(root.left, sum - root.val);
            if (subLeftResult.size() > 0) {
                for (List<Integer> tempPath: subLeftResult) {
                    tempPath.addAll(0, tempNewPath);
                }
                result.addAll(subLeftResult);
            }

            // calculate right path recursively
            List<List<Integer>> subRightResult = pathSum(root.right, sum - root.val);
            if (subRightResult.size() > 0) {
                for (List<Integer> tempPath: subRightResult) {
                    tempPath.addAll(0, tempNewPath);
                }
                result.addAll(subRightResult);
            }
        }

        return result;
    }
}
