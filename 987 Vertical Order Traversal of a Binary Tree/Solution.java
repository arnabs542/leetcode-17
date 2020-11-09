/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class TreeNodePosition {
        public int x;
        public int y;
        public int val;
        public TreeNodePosition(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // special case handling
        if (root == null) return new ArrayList<>();

        // use priority queue to sort the tree node based on the position and value
        PriorityQueue<TreeNodePosition> pq = new PriorityQueue<>(
            (a, b) -> ((a.x - b.x) != 0 ? (a.x - b.x) : (b.y - a.y) != 0 ? (b.y - a.y) : (a.val - b.val))
        );

        // use dfs to insert all tree node to the priority queue
        dfsTree(root, 0, 0, pq);

        // construct result based on priority queue
        return constructResult(pq);
    }

    private void dfsTree(TreeNode root, int x, int y, PriorityQueue<TreeNodePosition> pq) {
        // special case handling
        if (root == null || pq == null) return;

        TreeNodePosition node = new TreeNodePosition(x, y, root.val);
        pq.offer(node);

        // recursively dfs left and right child of the root node
        dfsTree(root.left, x - 1, y - 1, pq);
        dfsTree(root.right, x + 1, y - 1, pq);
    }

    private List<List<Integer>> constructResult(PriorityQueue<TreeNodePosition> pq) {
        List<List<Integer>> result = new ArrayList<>();
        TreeNodePosition prevNode = null;
        while (!pq.isEmpty()) {
            TreeNodePosition curNode = pq.poll();
            if (prevNode != null && curNode.x == prevNode.x) {
                result.get(result.size() - 1).add(curNode.val);
            } else {
                List<Integer> subResult = new ArrayList<>();
                subResult.add(curNode.val);
                result.add(subResult);
            }
            prevNode = curNode;
        }
        return result;
    }
}