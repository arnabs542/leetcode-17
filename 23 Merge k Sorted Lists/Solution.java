/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // Divid and concur
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return lists[start];
        }

        // start < end
        int mid = (start + end) / 2;
        ListNode firstHalf = mergeKLists(lists, start, mid);
        ListNode lastHalf = mergeKLists(lists, mid + 1, end);
        ListNode merge = mergeTwoList(firstHalf, lastHalf);
        return merge;
    }

    public ListNode mergeTwoList(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;

        ListNode head = null;
        ListNode curCurosr = null;
        ListNode curA = a;
        ListNode nextA = a.next;
        ListNode curB = b;
        ListNode nextB = b.next;

        while (curA != null && curB != null) {
            if (curA.val <= curB.val) {
                if (curCurosr == null) {
                    head = curA;
                } else {
                    curCurosr.next = curA;
                }
                curCurosr = curA;
                curA = nextA;
                nextA = (nextA == null) ? null : nextA.next;
            } else {
                if (curCurosr == null) {
                    head = curB;
                } else {
                    curCurosr.next = curB;
                }
                curCurosr = curB;
                curB = nextB;
                nextB = (nextB == null ) ? null : nextB.next;
            }
        }

        if (curA != null) {
            curCurosr.next = curA;
        } else if (curB != null) {
            curCurosr.next = curB;
        }

        return head;
    }
}