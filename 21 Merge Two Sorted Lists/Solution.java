/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//Another solution: http://fisherlei.blogspot.ca/2013/03/leetcode-merge-two-sorted-lists-solution.html

public class Solution {
	//No extra space needed
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if (l1 == null) return l2;
    	else if (l2 == null) return l1;
    	else if (l1.next == null) {
    		ListNode head = l1;

    		if (l2.val < l1.val) {
    			head = l2;

    			while (l2.next != null && l2.val < l1.val && l2.next.val < l1.val) {
    				l2 = l2.next;
    			}

    			l1.next = l2.next;
    			l2.next = l1;
    		}
    		else {
    			l1.next = l2;
    		}

    		return head;
    	}
    	else if (l2.next == null) {
			ListNode head = l1;

			if (l1.val >= l2.val) {
				head = l2;
				l2.next = l1;
			}
			else {
				while (l1.next != null && l1.val < l2.val && l1.next.val < l2.val) {
    				l1 = l1.next;
    			}

    			l2.next = l1.next;
    			l1.next = l2;
			}

			return head;
    	}
    	else {
    		ListNode head = l1;
	        ListNode l1Next = l1.next;
	        ListNode l2Next = l2.next;
	        if (l2.val < l1.val) head = l2;

	        while (l1Next != null && l2 != null) {
	        	if (l2.val >= l1.val && l2.val < l1Next.val) {
	        		l1.next = l2;
	        		l2.next = l1Next;

	        		l1 = l2;
	        		l2 = l2Next;
	        		if (l2Next != null) l2Next = l2Next.next;
	        	}
	        	else if (l2.val >= l1.val && l2.val >= l1Next.val) {
	        		l1 = l1Next;
	        		l1Next = l1Next.next;
	        	}
	        	else if (l2.val < l1.val) {
	        		l1Next = l1;
	        		l1 = l2;
	        		l1.next = l1Next;

	        		l2 = l2Next;
	        		if (l2Next != null) l2Next = l2.next;
	        	}
	        }

	        if (l1Next == null) {
	        	l1.next = l2;
	        }

	        return head;
	    }
    }
}