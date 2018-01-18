/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        List<Integer> nums = buildArrayFromListNode(root);
        ListNode[] newListNodes = buildListNodeArrayFromNumbers(nums, k);
        return newListNodes;
    }

    private List<Integer> buildArrayFromListNode(ListNode root) {
        List<Integer> nums = new ArrayList<Integer>();
        ListNode cursor = root;
        while (cursor != null) {
            nums.add(cursor.val);
            cursor = cursor.next;
        }
        return nums;
    }

    private ListNode[] buildListNodeArrayFromNumbers(List<Integer> nums, int k) {
        int size = nums.size();
        int group = k;
        int groupSize = size / group;
        int bigGroupCounter = size % group;

        ListNode[] newListNodes = new ListNode[group];

        // init group by group
        int numsCursor = 0;
        for (int i = 0; i < group; i++) {
            // determine group size
            int curGroupSize = groupSize;
            if (bigGroupCounter > 0) {
                curGroupSize++;
                bigGroupCounter--;
            }

            // init the group
            if (curGroupSize > 0) {
                ListNode tempHead = new ListNode(nums.get(numsCursor));
                numsCursor++;
                ListNode prevNode = tempHead;
                newListNodes[i] = tempHead;
                for (int j = 1; j < curGroupSize; j++) {
                    ListNode tempNode = new ListNode(nums.get(numsCursor));
                    numsCursor++;
                    prevNode.next = tempNode;
                    prevNode = tempNode;
                }
            }
        }

        return newListNodes;
    }
}
