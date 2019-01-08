class NumArray {
    // Binary Indexed Tree reference:
    // https://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/

    private int[] binaryIndexTree;
    private int[] nums;

    // O(n * log(n))
    public NumArray(int[] nums) {
        int len = nums.length;
        this.nums = new int[len + 1];
        this.binaryIndexTree = new int[len + 1];
        for(int i = 0; i < len; i++) {
            update(i, nums[i]);
        }
    }

    // O(log(n))
    public void update(int i, int val) {
        i++;
        int diff = val - this.nums[i];
        this.nums[i] = val;
        int len = this.binaryIndexTree.length;
        while(i < len) {
            this.binaryIndexTree[i] += diff;
            i += i & (i * (-1));
        }
    }

    // O(log(n))
    public int getSum(int i) {
        i++;
        int sum = 0;
        while(i > 0) {
            sum += this.binaryIndexTree[i];
            i -= i & (i * (-1));
        }
        return sum;
    }

    // O(log(n))
    public int sumRange(int i, int j) {
        if(i == 0) return getSum(j);
        return getSum(j) - getSum(i - 1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */