/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
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
	//use two pointers to solve this problem
	//one pointer is n elements ahead the other pointer
	//and they both move one element every time
	//when the first pointer reaches the last element
	//the other pointer reaches the n elements ahead the last elements
	//then just delete the other pointer
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ahead = head;
        ListNode cur = head;
        ListNode pre = null;

        for (int i = 0; i < (n - 1); i ++) {
        	ahead = ahead.next;
        }

        while (ahead != null && ahead.next != null) {
        	ahead = ahead.next;
        	pre = cur;
        	cur = cur.next;
        }

        if (pre == null) {
        	return cur.next;
        }
        else {
        	pre.next = cur.next;
        }

        return head;
    }
}