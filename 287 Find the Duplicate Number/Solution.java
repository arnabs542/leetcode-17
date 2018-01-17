// reference: http://bookshadow.com/weblog/2015/09/28/leetcode-find-duplicate-number/
// Very interesting problem
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        int finder = 0;
        do {
            slow = nums[slow];
            finder = nums[finder];
        } while (slow != finder);

        return slow;
    }
}
