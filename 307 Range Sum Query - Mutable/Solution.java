class NumArray {
    private int[] nums;

    // O(1)
    public NumArray(int[] nums) {
        this.nums = nums;
    }

    // O(1)
    public void update(int i, int val) {
        this.nums[i] = val;
    }

    // O(n)
    public int sumRange(int i, int j) {
        int sum = 0;
        for(int cursor = i; cursor <= j; cursor++) {
            sum += this.nums[cursor];
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */