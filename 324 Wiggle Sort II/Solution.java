class Solution {
    // Solution 1: Use Sort
    // Sort on the array and divide into two sub-array nums[1st half] and nums[2nd half]
    // put nums[1st half] into odd positions and nums[2nd half] into even postions to make sure nums[even] > nums[odd]
    // Time: O(n * logn), Space: O(n)
    // Another good solution: https://leetcode.com/problems/wiggle-sort-ii/discuss/77682/Step-by-step-explanation-of-index-mapping-in-Java
    public void wiggleSort(int[] nums) {
        // special case handling
        if (nums == null || nums.length == 0) return;

        // sort and make a copy of the array
        Arrays.sort(nums);
        int[] sortedNums = deepCopy(nums);

        // insert into original array from sorted array
        int smallHalf = (nums.length - 1) / 2;
        int bigHalf = nums.length -1;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                // even position
                nums[i] = sortedNums[smallHalf];
                smallHalf--;
            } else {
                // odd position
                nums[i] = sortedNums[bigHalf];
                bigHalf--;
            }
        }
    }

    private int[] deepCopy(int[] nums) {
        int[] newArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newArray[i] = nums[i];
        }
        return newArray;
    }
}