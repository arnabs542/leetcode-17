/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode leftNode = l1;
        ListNode rightNode = l2;
        int carry = 0;

        ListNode preNewNode = null;
        ListNode curNewNode = null;
        ListNode fistNode = null;

        int count = 0;
        // length of leftNode and rightNode might be different
        while (leftNode != null || rightNode != null) {
            // deal with cases that length of leftNode and rightNode are different
            if (leftNode == null) leftNode = new ListNode(0);
            if (rightNode == null) rightNode = new ListNode(0);

            // construct new node
            int newVal = (leftNode.val + rightNode.val + carry) % 10;
            curNewNode = new ListNode(newVal);
            if (preNewNode != null) {
                preNewNode.next = curNewNode;
            }

            // deal with the first node since it does not have previous node
            // and it will be the return node
            if (count == 0) {
                fistNode = curNewNode;
            }

            // update carry
            carry = (leftNode.val + rightNode.val + carry) / 10;

            // update iteration
            preNewNode = curNewNode;
            leftNode = leftNode.next;
            rightNode = rightNode.next;
            count++;
        }

        // deal with special case, e.g. [5], [5] -> [0,1]
        if (carry != 0) {
            curNewNode = new ListNode(carry);
            preNewNode.next = curNewNode;
        }

        return fistNode;
    }
}
