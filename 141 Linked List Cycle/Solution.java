/*
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

//Solution: http://www.programcreek.com/2012/12/leetcode-linked-list-cycle/

public class Solution {
	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		if (head == null) return false;
		if (head.next == null) return false;

		while (fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) return true;
		}

		return false;
	}

    public boolean hasCycle_WithExtraSpace(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();

        while (head != null) {
        	if (set.contains(head)) return true;
        	else {
        		set.add(head);
        	}

        	head = head.next;
        }

        return false;
    }
}