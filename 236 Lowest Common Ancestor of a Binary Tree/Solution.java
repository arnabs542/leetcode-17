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
    // use DFS to get the ancester chain of each node, and calculate the LCA
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pAncester = new ArrayList<>();
        List<TreeNode> qAncester = new ArrayList<>();
        List<TreeNode> currentAncester = new ArrayList<>();

        // use DFS to get the ancester chain of each nod
        dfs(root, p, q, currentAncester, pAncester, qAncester);

        // calculate the LCA
        return getLCA(pAncester, qAncester);
    }

    private void dfs(
        TreeNode root,
        TreeNode p,
        TreeNode q,
        List<TreeNode> currentAncester,
        List<TreeNode> pAncester,
        List<TreeNode> qAncester) {
            // special case handling
            if (root == null) return;

            // pruning - we already find p & q
            if (pAncester.size() > 0 && qAncester.size() > 0) return;

            currentAncester.add(root);

            // check if we found p or q
            if (root.val == p.val) {
                pAncester.addAll(currentAncester);
            }
            if (root.val == q.val) {
                qAncester.addAll(currentAncester);
            }

            // recursively check each node and its ancester chain
            dfs(root.left, p, q, currentAncester, pAncester, qAncester);
            dfs(root.right, p, q, currentAncester, pAncester, qAncester);
            currentAncester.remove(currentAncester.size() - 1);
    }

    private TreeNode getLCA(List<TreeNode> pAncester, List<TreeNode> qAncester) {
        int pLen = pAncester.size();
        int qLen = qAncester.size();
        TreeNode lca = pAncester.get(0);
        for (int i = 0; i < Math.min(pLen, qLen); i++) {
            // based on the assumption of all Node.val are unique, otherwise we need to check the continuity
            if (pAncester.get(i).val == qAncester.get(i).val) {
                lca = pAncester.get(i);
            }
        }
        return lca;
    }
}