// referrence: http://bookshadow.com/weblog/2016/10/25/leetcode-find-all-duplicates-in-an-array/
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int curValue = Math.abs(nums[i]);
            if (nums[curValue - 1] < 0) {
              result.add(curValue);
            }
            nums[curValue - 1] = (-1) * nums[curValue - 1];
        }
        return result;
    }
}
