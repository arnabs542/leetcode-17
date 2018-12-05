/**
 * To find the next greater permutation, we can compare digit to digit from right to the left until we find the right digit is less than the left one, if we did not find it, output the number in the reverse order.
 * Once we find the digit, swap with the next greater digit on the right, then reverse the order of the all the digits on the right side, as then all the digits on the right side will be in descending order.
 */

class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) return;

        for(int i = nums.length - 2; i >= 0; i--) {
            // to find the digit that needs to be adjusted
            if(nums[i] < nums[i + 1]) {
                // swap with the digit next greater than the current one
                for(int j = i + 1; j < nums.length; j++) {
                    if(j == nums.length - 1 || (nums[j] > nums[i] && nums[j + 1] <= nums[i])) {
                        swap(nums, i, j);
                        reverse(nums, i + 1, nums.length - 1);
                        return;
                    }
                }
            }
        }

        // the current number is already the max number
        reverse(nums, 0, nums.length - 1);
    }

    public void swap(int[] nums, int pos1, int pos2) {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }

    public void reverse(int[] nums, int start, int end) {
        if(end <= start) return;
        int mid = (start + end) / 2;
        for(int i = start; i <= mid; i++) {
            swap(nums, i, end + start - i);
        }
    }
}