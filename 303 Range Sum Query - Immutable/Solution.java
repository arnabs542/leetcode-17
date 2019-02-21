// Maybe we can also consider Binary Indexed Tree for this problem
class NumArray {
    private int len = 0;
    private int[] sums;

    public NumArray(int[] nums) {
        this.len = nums.length;
        this.sums = buildSums(nums);
    }

    public int sumRange(int i, int j) {
        if (i == 0) return this.sums[j];
        else return this.sums[j] - this.sums[i - 1];
    }

    private int[] buildSums(int[] nums) {
        int len = nums.length;
        int[] sums = new int[len];
        for(int i = 0; i < len; i++) {
            if(i == 0) sums[i] = nums[i];
            else sums[i] = sums[i - 1] + nums[i];
        }
        return sums;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */