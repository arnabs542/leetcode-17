/*
Sort a linked list using insertion sort.
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
    public ListNode insertionSortList(ListNode head) {
    	int MIN_INT = -2147483648;

        if (head == null || head.next == null) {
        	return head;
        }

        // current working node of original list
        ListNode cur = head;
        // virtual head node only for fixing the head
        ListNode preHead = new ListNode(MIN_INT);

        // insertion sort
        while (cur != null) {
        	ListNode next = cur.next;

        	ListNode temp = preHead;
        	while (temp != null) {
        		int tempVal = cur.val;

        		if (tempVal >= temp.val) {
        			if (temp.next != null) {
        				if (temp.next.val > tempVal) {
        					insertNode(temp, cur);
        					break;
        				}
        			}
        			else {
        				insertNode(temp, cur);
        				break;
        			}
        		}
        		else {
        			// do nothing, since this step cannot be executed
        		}

        		temp = temp.next;
        	}

        	cur = next;
        }

        return preHead.next;
    }

    void insertNode (ListNode node, ListNode insertion) {
    	insertion.next = null;

    	if (node.next == null) {
    		node.next = insertion;
    	}
    	else {
    		ListNode temp = node.next;
    		node.next = insertion;
    		insertion.next = temp;
    	}
    }
}