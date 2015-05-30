/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
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
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
        	return head;
        }
        else {
        	ListNode previous = head;
        	ListNode current = head.next;

        	while (current != null) {
        		if (previous.val == current.val) {
        			previous.next = current.next;
        		}
        		else {
        			previous = previous.next;
        		}
        		
        		current = current.next;
        	}

        	return head;
        }
	}

    public ListNode deleteDuplicates_Original(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        else {
        	Set<Integer> set = new HashSet<Integer>();
        	set.add(head.val);

        	ListNode previous = head;
        	ListNode current = head.next;

        	while (current != null) {
        		if (set.contains(current.val)) {
        			previous.next = current.next;
        			current = current.next;
        		}
        		else {
        			set.add(current.val);
        			previous = current;
        			current = current.next;
        		}
        	}

        	return head;
        }
    }
}