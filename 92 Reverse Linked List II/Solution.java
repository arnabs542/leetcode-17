/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m == n) return head;

        int cursorCount = 1;
        ListNode cursor = head;
        ListNode prevCursor = null;
        // the previous node of first node of the reverse
        ListNode prevStart = null;
        // first node of the reverse
        ListNode start = null;

        while(cursor != null && cursorCount <= n) {
            ListNode nextCursor = cursor.next;
            if(cursorCount > m && cursorCount <= n) {
                // reverse the current node
                cursor.next = prevCursor;
            } else if(cursorCount == m) {
                // start of the reverse
                prevStart = prevCursor;
                start = cursor;
            }

            // end of reverse
            if(cursorCount == n) {
                // update start
                if(prevStart != null) {
                    prevStart.next = cursor;
                } else {
                    head = cursor;
                }
                // update end
                start.next = nextCursor;
            }

            // update interation variables
            prevCursor = cursor;
            cursor = nextCursor;
            cursorCount++;
        }

        return head;
    }
}