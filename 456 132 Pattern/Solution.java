// reference: http://www.cnblogs.com/grandyang/p/6081984.html
class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        int n = nums.length;
        int i = 0, j = 0, k = 0;

        while (i < n) {
            while (i < n - 2 && nums[i] >= nums[i + 1]) i++;
            j = i + 1;
            while (j < n - 1 && nums[j] <= nums[j + 1]) j++;
            k = j + 1;
            while (k < n) {
                if (nums[k] > nums[i] && nums[k] < nums[j]) return true;
                k++;
            }
            i = j + 1;
        }

        return false;
    }

    // this solution has complex of O(n^3), this might be a good solution to find all 132 Pattern
    // not for just return true or false to tell if it has 132 pattern or not
    public boolean _find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        int len = nums.length;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[j] > nums[i]) {
                    for (int k = j + 1; k < len; k++) {
                      if (nums[k] > nums[i] && nums[j] > nums[k]) {
                        return true;
                      }
                    }
                }
            }
        }

        return false;
    }
}
