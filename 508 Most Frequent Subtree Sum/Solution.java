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
    public int[] findFrequentTreeSum(TreeNode root) {
        // Map<treeSum, frequency>
        Map<Integer,Integer> result = new HashMap<Integer, Integer>();
        this._buildFrequentTreeSum(root, result);
        return this._findFrequentTreeSum(result);
    }

    private int _buildFrequentTreeSum(TreeNode root, Map<Integer, Integer> result) {
        if (root != null) {
            int currentFrequentTreeSum = this._buildFrequentTreeSum(root.left, result) + this._buildFrequentTreeSum(root.right, result) + root.val;
            if (result.get(currentFrequentTreeSum) != null) {
                result.put(currentFrequentTreeSum, result.get(currentFrequentTreeSum) + 1);
            } else {
                result.put(currentFrequentTreeSum, 1);
            }
            return currentFrequentTreeSum;
        } else {
            return 0;
        }
    }

    private int[] _findFrequentTreeSum(Map<Integer, Integer> result) {
        int maxFrequency = 0;
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            int frequency = entry.getValue();
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            int frequency = entry.getValue();
            if (frequency == maxFrequency) {
                list.add(entry.getKey());
            }
        }
        int[] resultInt = new int[list.size()];
        for (int i = 0; i < list.size(); i ++) {
            resultInt[i] = list.get(i);
        }
        return resultInt;
    }
}
