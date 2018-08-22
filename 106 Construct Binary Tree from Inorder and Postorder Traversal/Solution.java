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
    // recursion
    // Since Tree is naturally defined recursively, we should alwasys consider recursion to solve tree problems

    // this method does not new int array to save space
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(
        int[] inorder, int inorderStart, int inorderEnd,
        int[] postorder, int postorderStart, int postorderEnd) {
        int lenInOrder = inorderEnd - inorderStart + 1;
        int lenPostOrder = postorderEnd - postorderStart + 1;

        if (lenInOrder != lenPostOrder) return null;
        if (lenInOrder == 0) return null;
        if (lenInOrder == 1) return new TreeNode(inorder[inorderStart]);

        int rootNodeVal = postorder[postorderEnd];
        TreeNode rootNode = new TreeNode(rootNodeVal);

        int rootNodeIdx = findIndex(inorder, inorderStart, inorderEnd, rootNodeVal);

        rootNode.left = buildTree(inorder, inorderStart, rootNodeIdx - 1, postorder, postorderStart, postorderStart + rootNodeIdx - inorderStart - 1);
        rootNode.right = buildTree(inorder, rootNodeIdx + 1, inorderEnd, postorder, postorderStart + rootNodeIdx - inorderStart, postorderEnd - 1);

        return rootNode;
    }

    // this method will always new array to waste space, but the logic is more clear
    public TreeNode buildTree_old(int[] inorder, int[] postorder) {
        int lenInOrder = inorder.length;
        int lenPostOrder = postorder.length;

        if (lenInOrder != lenInOrder) return null;
        if (lenInOrder == 0) return null;
        if (lenInOrder == 1) return new TreeNode(inorder[0]);

        int rootNodeVal = postorder[lenPostOrder - 1];
        TreeNode rootNode = new TreeNode(rootNodeVal);

        int rootNodeIdx = findIndex(inorder, rootNodeVal);

        int[] leftChildInorder = constructArrayByRange(inorder, 0, rootNodeIdx - 1);
        int[] leftChildPostorder = constructArrayByRange(postorder, 0, rootNodeIdx - 1);
        int[] rightChildInorder = constructArrayByRange(inorder, rootNodeIdx + 1, lenInOrder - 1);;
        int[] rightChildPostorder = constructArrayByRange(postorder, rootNodeIdx, lenInOrder - 2);

        rootNode.left = buildTree(leftChildInorder, leftChildPostorder);
        rootNode.right = buildTree(rightChildInorder, rightChildPostorder);

        return rootNode;
    }

    private int findIndex(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) return i;
        }
        return -1;
    }

    private int findIndex(int[] arr, int start, int end, int val) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == val) return i;
        }
        return -1;
    }

    private int[] constructArrayByRange(int[] arr, int start, int end) {
        int[] newArr = new int[end - start + 1];
        for (int i = start; i <= end; i++) {
            newArr[i - start] = arr[i];
        }
        return newArr;
    }
}