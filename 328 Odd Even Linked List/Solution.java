/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode oddListCurNode = head;
        ListNode evenListCurNode = head.next;
        ListNode evenListHead = evenListCurNode;

        while (oddListCurNode != null &&
                oddListCurNode.next != null &&
                evenListCurNode != null &&
                evenListCurNode.next != null) {
            oddListCurNode.next = oddListCurNode.next.next;
            oddListCurNode = oddListCurNode.next;
            evenListCurNode.next = evenListCurNode.next.next;
            evenListCurNode = evenListCurNode.next;
        }

        oddListCurNode.next = evenListHead;

        return head;
    }
}
