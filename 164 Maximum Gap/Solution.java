class Solution {
    class Bucket {
        private int min;
        private int max;

        public Bucket(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getMin() {
            return this.min;
        }

        public int getMax() {
            return this.max;
        }
    }

    // for solution with linear time and space, see reference: https://www.cnblogs.com/higerzhang/p/4176108.html
    public int maximumGap(int[] nums) {
        int len = nums.length;
        if (len <= 1) return 0;

        // find min and max values
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (nums[i] < min) min = nums[i];
            if (nums[i] > max) max = nums[i];
        }
        if (min == max) return 0;

        // calculate number of buckets and interval of a bucket
        int bucketInterval = (int) Math.ceil((max - min)/(len - 1)) + 1;
        int bucketNum = (int) Math.ceil((max - min)/bucketInterval) + 1;

        // initiate list of buckets
        List<Bucket> buckets = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            buckets.add(new Bucket(Integer.MAX_VALUE, Integer.MIN_VALUE));
        }

        // insert numbers into buckets to fulfill buckets info
        for (int i = 0; i < len; i++) {
            int bucketIdx = (nums[i] - min)/bucketInterval;
            Bucket curBucket = buckets.get(bucketIdx);
            if (nums[i] > curBucket.getMax()) curBucket.setMax(nums[i]);
            if (nums[i] < curBucket.getMin()) curBucket.setMin(nums[i]);
        }

        // loop through buckets to find the max gap
        int maxGap = 0;
        if (bucketNum == 1) return buckets.get(0).getMax() - buckets.get(0).getMin();
        Bucket prevBucket = buckets.get(0);
        for (int i = 1; i < bucketNum; i++) {
            Bucket curBucket = buckets.get(i);
            if (curBucket.getMax() >= curBucket.getMin()) {
                if (prevBucket.getMax() >= prevBucket.getMin()) {
                    if ((curBucket.getMin() - prevBucket.getMax()) > maxGap) maxGap = curBucket.getMin() - prevBucket.getMax();
                }
                prevBucket = curBucket;
            }
        }

        return maxGap;
    }

    public int maximumGap_badTimeCompl(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int maxGap = 0;
        for (int i = 1; i < len; i++) {
            if ((nums[i] - nums[i - 1]) > maxGap) maxGap = nums[i] - nums[i - 1];
        }
        return maxGap;
    }
}