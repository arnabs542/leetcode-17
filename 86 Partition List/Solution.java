/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
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
    public ListNode partition(ListNode head, int x) {
    	//current retriving node
        ListNode cur = head;
        //one node preceding the current node
        ListNode preCur = null;

        //the last position that less than x
        ListNode partition = null;

        //this linked list has elements greater than x or not
        boolean grtThenX = false;

        while (cur != null) {
        	if (cur.val >= x) {
        		//there are some elements that greater than x
        		grtThenX = true;
        	}

        	if (grtThenX) {
        		//there are some element greater x before and current node is less than x
        		//put the current node after the partition
        		if (cur.val < x) {
        			//delink the current node
        			ListNode temp = cur;
        			cur = cur.next;
        			preCur.next = cur;

        			//put the current node just after the partition node
        			if (partition == null) {
        				partition = temp;
        				partition.next = head;
        				head = partition;
        			}
        			else {
	        			ListNode tempNext = partition.next;
	        			partition.next = temp;
	        			temp.next = tempNext;
	        			partition = temp;
	        		}
        		}
        		else {
        			preCur = cur;
        			cur = cur.next;
        		}
        	}
        	else {
        		preCur = cur;
				cur = cur.next;
				if (partition == null) {
					partition = head;
				}
				else {
        			partition = partition.next;
        		}
        	}
        }

        return head;
    }
}