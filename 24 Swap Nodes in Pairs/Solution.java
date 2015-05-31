/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode temp = head.next;
        head.next = head.next.next;
        temp.next = head;
        head = temp;

        ListNode pre = null;
        ListNode e1 = head;
        ListNode e2 = head.next;
        ListNode next = head.next.next;

       while (next != null && next.next != null) {
       		pre = e2;
       		e1 = next;
       		e2 = next.next;
       		next = e2.next;

       		pre.next = e2;
       		e1.next = next;
       		e2.next = e1;

       		temp = e1;
       		e1 = e2;
       		e2 = temp;
       }

        return head;
    }
}