/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // quick return for basic cases
        if(head == null) return head;

        // prvious node of the current node
        ListNode prevNode = null;
        // temp node for interating through the linked list
        ListNode curNode = head;

        while(curNode != null && curNode.next != null) {
            // find the first node that has duplicates
            while(curNode != null && curNode.next != null && curNode.val != curNode.next.val) {
                prevNode = curNode;
                curNode = curNode.next;
            }
            if(curNode != null && curNode.next != null) {
                // find the next node that has new value
                ListNode nextUniqueNode = findNextUniqueNode(curNode);
                if(prevNode == null) {
                    // deal with head node
                    if(nextUniqueNode != null && nextUniqueNode.next != null && nextUniqueNode.val != nextUniqueNode.next.val) {
                        head = nextUniqueNode;
                    }
                } else {
                    // link the previous node to the next node with new value
                    prevNode.next = nextUniqueNode;
                }
                // reset current temp node
                curNode = nextUniqueNode;
            }
        }

        if(prevNode == null) {
            if(curNode != null) return curNode;
            else return null;
        }
        return head;
    }

    private ListNode findNextUniqueNode(ListNode head) {
        ListNode curNode = head;
        while(curNode != null && curNode.next != null && curNode.val == curNode.next.val) {
            curNode = curNode.next;
        }
        return curNode.next;
    }
}