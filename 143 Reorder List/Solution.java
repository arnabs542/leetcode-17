// reference: http://blog.csdn.net/mine_song/article/details/71762350

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        // get the mid node of the list
        ListNode midNode = getMidNode(head);

        // reverse the last half nodes of the list
        ListNode nextOfMidNode = midNode.next;
        midNode.next = null;
        ListNode headNodeOfReverseList = reverseList(nextOfMidNode);

        // merge two list in the same order
        ListNode newHeadNode = mergeLists(head, headNodeOfReverseList);

        head = newHeadNode;
        return;
    }

    public ListNode getMidNode(ListNode head) {
        ListNode oneStepNode = head;
        ListNode twoStepNode = head;

        while (twoStepNode.next != null && twoStepNode.next.next != null) {
            oneStepNode = oneStepNode.next;
            twoStepNode = twoStepNode.next.next;
        }

        return oneStepNode;
    }

    public ListNode reverseList(ListNode head) {
        ListNode curNode = null;
        ListNode nextNode = head;
        ListNode newHead = nextNode;

        while (nextNode != null) {
            ListNode nextNextNode = nextNode.next;

            // reverse the order
            nextNode.next = curNode;
            newHead = nextNode;

            // update iteration cursor
            curNode = nextNode;
            nextNode = nextNextNode;
        }

        return newHead;
    }

    public ListNode mergeLists(ListNode headOne, ListNode headTwo) {
        ListNode listOneCurNode = headOne;
        ListNode listTwoCurNode = headTwo;

        while (listOneCurNode != null && listTwoCurNode!= null) {
            ListNode listOneNextNode = listOneCurNode.next;

            // merge two lists
            listOneCurNode.next = listTwoCurNode;
            listTwoCurNode = listTwoCurNode.next;
            listOneCurNode.next.next = listOneNextNode;

            // update iteration cursor
            listOneCurNode = listOneNextNode;
        }

        return headOne;
    }
}
