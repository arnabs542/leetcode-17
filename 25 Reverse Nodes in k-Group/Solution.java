/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x2) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode preStartNode = null;
        ListNode startNode = head;
        while (startNode != null) {
            ListNode endNode = startNode;
            int count = 1;
            while (count < k && endNode != null) {
                endNode = endNode.next;
                count++;
            }
            if (endNode == null) {
                return head;
            } else {
                // start will be end, end will be start
                reverseList(preStartNode, startNode, endNode);
                if (preStartNode == null) head = endNode;
                preStartNode = startNode;
                startNode = startNode.next;
            }
        }
        return head;
    }

    public void reverseList(ListNode preStartNode, ListNode startNode, ListNode endNode) {
        ListNode afterEndNode = endNode.next;
        if (preStartNode != null) preStartNode.next = endNode;

        ListNode curNode = startNode;
        ListNode nextNode = startNode.next;
        while (curNode != endNode) {
            ListNode afterNextNode = nextNode.next;
            nextNode.next = curNode;
            curNode = nextNode;
            nextNode = afterNextNode;
        }

        startNode.next = afterEndNode;
    }

    public ListNode initListNodesFromArray(int[] input) {
        int len = input.length;
        ListNode head = null;
        ListNode curNode = null;
        ListNode preNode = null;
        for (int i = 0; i < len; i++) {
            int value = input[i];
            curNode = new ListNode(value);
            if (preNode != null) preNode.next = curNode;
            preNode = curNode;
            if (i == 0) head = curNode;
        }
        return head;
    }

    public void printListNode(ListNode head) {
        while(head != null) {
            System.out.print(head.val + ",");
            head = head.next;
        }
    }
}