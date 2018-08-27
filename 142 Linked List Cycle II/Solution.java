/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // with extra space
    // iterate through the linked list, find the first element that occurs twice, that is where cycle begins
    // if no nodes duplicates, there is no cycle here
    // for another solution not using extra space, see https://www.qiujiawei.com/leetcode-problem-142/
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> listNodeSet = new HashSet<>();
        ListNode curNode = head;
        while (curNode != null) {
            if (listNodeSet.contains(curNode)) {
                return curNode;
            }
            listNodeSet.add(curNode);
            curNode = curNode.next;
        }
        return null;
    }
}