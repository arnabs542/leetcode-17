/*
Reverse a singly linked list.

Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;
		else {
			ListNode next = head.next;
			ListNode result = reverseList(next);
			next.next = head;
			head.next = null;

			return result;
		}
	}

    public ListNode reverseList_Iteratively(ListNode head) {
        if (head == null || head.next == null) return head;
        else {
        	ListNode pre = null;
        	ListNode current = head;
        	ListNode next = head.next;

        	while (current != null) {
        		current.next = pre;

        		pre = current;
        		current = next;
        		if (next != null) next = next.next;
        	}

        	return pre;
        }
    }
}