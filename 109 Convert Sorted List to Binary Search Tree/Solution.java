/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	//Always find the mid element to create a new Treenode
	//And then recursively create the left and right nodes
    public TreeNode sortedListToBST(ListNode head) {
        ListNodes listNodes = getMid(head);
        ListNode mid = listNodes.mid;
        ListNode pre = listNodes.pre;

        if (mid != null) {
        	TreeNode node = new TreeNode(mid.val);
        	if (pre != null) {
        		pre.next = null;
        		node.left = sortedListToBST(head);
        	}
        	if (mid.next != null) {
        		node.right = sortedListToBST(mid.next);
        	}

        	return node;
        }

        return null;
    }

    //Use two pointers method to get the mid and one node before mid elements of the linked list
    private ListNodes getMid (ListNode head) {
    	if (head == null || head.next == null || head.next.next == null) {
    		ListNodes listNodes = new ListNodes(null, head);
    		return listNodes;
    	}
    	else {
    		ListNode pre = head;
    		ListNode slow = head.next;
    		ListNode fast = head.next.next;

    		while (fast != null && fast.next != null) {
    			pre = pre.next;
    			slow = slow.next;
    			fast = fast.next.next;
    		}

    		ListNodes listNodes = new ListNodes(pre, slow);
    		return listNodes;
    	}
    }

    //A data structure that stores the one node before mid named pre and the mid element of the linked list
    private class ListNodes {
    	public ListNode pre;
    	public ListNode mid;

    	public ListNodes (ListNode pre, ListNode mid) {
    		this.pre = pre;
    		this.mid = mid;
    	}
    }
}