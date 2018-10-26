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
    private List<TreeNode> nodePath;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<>();

        // handle special case that the distance is 0
        if(K == 0) {
            result.add(target.val);
            return result;
        }

        // find all upstream nodes
        List<TreeNode> nodesInPath = getPathToTarget(root, target);
        for(int distance = 1; distance <= nodesInPath.size() - 1; distance++) {
            TreeNode curNode = nodesInPath.get(nodesInPath.size() - 1 - distance);
            if(distance == K) {
                result.add(curNode.val);
            } else if(distance < K) {
                TreeNode nextNode = nodesInPath.get(nodesInPath.size() - distance);
                if(curNode.left == nextNode) {
                    findNodeWithDistance(curNode.right, target, K - distance - 1, result);
                } else {
                    findNodeWithDistance(curNode.left, target, K - distance - 1, result);
                }
            }
        }

        // find all downstream nodes
        findNodeWithDistance(target.left, target, K - 1, result);
        findNodeWithDistance(target.right, target, K - 1, result);

        return result;
    }

    private void findNodeWithDistance(TreeNode root, TreeNode target, int distance, List<Integer> result) {
        if(root != null && distance >= 0 && root != target) {
            if(distance == 0) {
                result.add(root.val);
            } else {
                findNodeWithDistance(root.left, target, distance - 1, result);
                findNodeWithDistance(root.right, target, distance - 1, result);
            }
        }
    }

    private List<TreeNode> getPathToTarget(TreeNode root, TreeNode target) {
        this.nodePath = new ArrayList<>();
        List<TreeNode> path = new ArrayList<>();
        DFSGetPathToTarget(root, target, path);
        return this.nodePath;
    }

    private void DFSGetPathToTarget(TreeNode root, TreeNode target, List<TreeNode> path) {
        if(root != null) {
            path.add(root);
            if(root != target) {
                DFSGetPathToTarget(root.left, target, path);
                DFSGetPathToTarget(root.right, target, path);
            } else {
                this.nodePath = new ArrayList<TreeNode>(path);
            }
            path.remove(root);
        }
    }
}