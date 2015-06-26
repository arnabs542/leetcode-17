/*
Sort a linked list in O(n log n) time using constant space complexity.
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
	//Reference: https://leetcode.com/discuss/1709/have-pretty-mergesort-method-anyone-speed-reduce-memory-usage
	//Reference: http://blog.csdn.net/linhuanmars/article/details/21133949

	//Since the runtime requirement is O(n Log(n)), we can think of generic sorting algorithms, 
	//like QuickSort, MergeSort, HeapSort.
	//Since QuickSort require to use the position of the list very often, it is very difficult 
	//to use QuickSort here in a linked list.
	//Since merging two sorted linked list is eaiser, we can consider MergeSort here.
	//We can use slow and fast pointer to divide the linked list into two ones.
    public ListNode sortList (ListNode head) {
        if (head != null && head.next != null) {
        	head = mergeSort(head);
        }
        return head;
    }

    private ListNode mergeSort (ListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	}
    	else {
    		ListNode fast = head.next.next;
    		ListNode slow = head;

    		while (fast != null && fast.next != null) {
				fast = fast.next.next;
    			slow = slow.next;
    		} 

    		ListNode rightHead = mergeSort(slow.next);
    		slow.next = null;
    		ListNode leftHead = mergeSort(head);
    		
    		return merge(leftHead, rightHead);
    	}
    }

    private ListNode merge (ListNode left, ListNode right) {
    	ListNode head = left;
    	ListNode leftTempPre = null;
    	ListNode leftTemp = left;
    	ListNode rightTemp = right;

    	while (leftTemp != null && rightTemp != null) {
    		if (leftTemp == left && head == left && leftTemp.val > rightTemp.val) {
				head = rightTemp;
				rightTemp = rightTemp.next;
				head.next = leftTemp;
				leftTempPre = head;    			
    		}
    		else if (leftTemp.val > rightTemp.val) {
    			leftTempPre.next = rightTemp;
    			leftTempPre = rightTemp;
				rightTemp = rightTemp.next;
				leftTempPre.next = leftTemp;
    		}
    		else if (leftTemp.val <= rightTemp.val) {
    			leftTempPre = leftTemp;
    			leftTemp = leftTemp.next;
    		}
    	}

    	if (leftTemp == null && rightTemp != null) {
    		leftTempPre.next = rightTemp;
    	}

    	return head;
    }
}