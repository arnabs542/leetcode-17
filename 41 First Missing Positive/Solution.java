class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        // swap numbers to put them on the corresponding position
        for(int i = 0; i < len; i++) {
            int curVal = nums[i];
            if(curVal < (len + 1) &&
                curVal > 0 &&
                curVal != (i + 1) &&
                curVal != nums[curVal - 1]) {
                // swap the number to put at position of nums[i] - 1
                int temp = nums[curVal - 1];
                nums[curVal - 1] = curVal;
                nums[i] = temp;
                // need to validate current value after swap again
                i--;
            }
        }

        // check missing number
        int result = 1;
        for(int i = 0; i < len; i++) {
            if(nums[i] != (i + 1)) break;
            result++;
        }
        return result;
    }

    public int firstMissingPositive_old(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int curNum: nums) {
            if(curNum <= (n + 1)) {
                set.add(curNum);
            }
        }
        for(int i = 1; i <= (n + 1); i++) {
            if(!set.contains(i)) {
                return i;
            }
        }
        return 1;
    }
}