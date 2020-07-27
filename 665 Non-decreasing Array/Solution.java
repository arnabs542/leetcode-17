class Solution {
    public boolean checkPossibility(int[] nums) {
        int modify = 0;
        int len = nums.length;
        if (len <= 1) return true;

        for(int i = 1; i < len; i++) {
            if (nums[i - 1] > nums[i]) {
                modify++;
                if(i > 1 && nums[i - 2] > nums[i]) nums[i] = nums[i - 1];
            }
            if (modify > 1) return false;
        }

        return true;
    }
}