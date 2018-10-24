/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }
        String serial = "V" + root.val + "L" + serialize(root.left) + "R" + serialize(root.right);
        return serial;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // null instance
        if(data.length() == 0) return null;

        int lIndex = data.indexOf("L");
        int rIndex = 0;
        int val = Integer.parseInt(data.substring(data.indexOf("V") + 1, lIndex));

        // find next R index
        Stack<Character> stack = new Stack<>();
        for(int i = lIndex + 1; i < data.length(); i++) {
            char curChar = data.charAt(i);
            if(curChar == 'V') {
                stack.push('V');
            } else if(curChar == 'R') {
                if(stack.empty()) {
                    rIndex = i;
                    break;
                } else {
                    stack.pop();
                }
            }
        }

        String leftNode = data.substring(lIndex + 1, rIndex);
        String rightNode = data.substring(rIndex + 1, data.length());
        TreeNode node = new TreeNode(val);
        node.left = deserialize(leftNode);
        node.right = deserialize(rightNode);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));