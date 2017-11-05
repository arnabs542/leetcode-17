/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        // constructing list of ListNodes by looping through linked list
        List<ListNode> listNodes = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            listNodes.add(temp);
            temp = temp.next;
        }

        // find old end, new head and new end nodes
        int len = listNodes.size();
        ListNode newHead = listNodes.get(((len - k) % len + len) % len);
        ListNode newEnd = listNodes.get(((len - k - 1) % len + len) % len);
        ListNode oldEnd = listNodes.get(len - 1);

        // out put new linked list by right-shift k elements
        newEnd.next = null;
        if (oldEnd != newEnd) {
            oldEnd.next = head;
        }

        return newHead;
    }
}
