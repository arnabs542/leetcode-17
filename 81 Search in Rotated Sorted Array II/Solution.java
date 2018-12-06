// Thoughts:
// The simplest way we can do it is just to scan the array and return if we find the element. The Time complexity would be O(n) then.
// Thus, if we want to further optimize it, we should try methods better than O(n).
// To use binary search, it could reach O(n * log(n)). As this array is not restricted sorted as it is sorted in two parts.
// We need to know the bounray between each part.
// We can use binary search again to find the bounary, which takes another O(n * log(n)), but the overall time complexity is still O(n * log(n)).
// Reference: https://blog.csdn.net/happyaaaaaaaaaaa/article/details/51602234

class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;

        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) return true;

            // separate into cases to analyze
            if(nums[mid] == nums[left]) {
                left++;
            } else if(nums[mid] > nums[left]) {
                if(target >= nums[left] && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if(target > nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }

        return false;
    }

    public boolean search_linear(int[] nums, int target) {
        for(int num: nums) {
            if(num == target) return true;
        }
        return false;
    }
}