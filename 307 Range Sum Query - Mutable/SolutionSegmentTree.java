class NumArray {
    // Segment Tree reference:
    // https://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/

    class Node {
        public int start;
        public int end;
        public int val;
        public Node left;
        public Node right;

        public Node(int start, int end, int val) {
            this.start = start;
            this.end = end;
            this.val = val;
        }
    }

    // build segment tree recursively
    private Node constructSegmentTree(int[] nums, int start, int end) {
        if(start > end) return null;
        if(start == end) {
            return new Node(start, start, nums[start]);
        } else {
            int mid = (start + end) / 2;
            Node left = constructSegmentTree(nums, start, mid);
            Node right = constructSegmentTree(nums, mid + 1, end);
            Node root = new Node(start, end, left.val + right.val);
            root.left = left;
            root.right = right;
            return root;
        }
    }

    // update segment tree recursively
    private void updateNode(Node root, int pos, int diff) {
        if(root == null) return;
        if(root.start <= pos && pos <= root.end) {
            root.val += diff;
            updateNode(root.left, pos, diff);
            updateNode(root.right, pos, diff);
        }
    }

    // get sum range recursively
    private int getSumRange(Node root, int start, int end) {
        if(root == null) return 0;
        if(root.start <= start && root.end >= end) {
            if(root.start == start && root.end == end) {
                return root.val;
            } else {
                int result = 0;
                // fall into the left child
                if(root.left != null && root.left.end >= start) {
                    if(root.left.end >= end) {
                        result += this.getSumRange(root.left, start, end);
                    } else {
                        result += this.getSumRange(root.left, start, root.left.end);
                    }
                }
                // fall into the right child
                if(root.right != null && root.right.start <= end) {
                    if(root.right.start >= start) {
                        result += this.getSumRange(root.right, root.right.start, end);
                    } else {
                        result += this.getSumRange(root.right, start, end);
                    }
                }
                return result;
            }
        } else {
            return 0;
        }
    }

    private Node root;
    private int[] nums;

    // O(n)
    public NumArray(int[] nums) {
        this.nums = nums;
        this.root = constructSegmentTree(nums, 0, nums.length - 1);
    }

    // O(log(n))
    public void update(int i, int val) {
        this.updateNode(this.root, i, val - this.nums[i]);
        this.nums[i] = val;
    }

    // O(log(n))
    public int sumRange(int i, int j) {
        return this.getSumRange(this.root, i, j);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */