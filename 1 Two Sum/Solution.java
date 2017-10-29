class Solution {
    class NumWIndex implements Comparable<NumWIndex>{
        public int num;
        public int index;

        public NumWIndex(int num, int index) {
            this.num = num;
            this.index = index;
        }

        @Override
        public int compareTo(NumWIndex tempNumWIndex) {
            return this.num - tempNumWIndex.num;
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int len = nums.length;
        NumWIndex[] listOfNums = new NumWIndex[len];

        for (int i = 0; i < len; i++) {
            NumWIndex tempNumWIndex = new NumWIndex(nums[i], i);
            listOfNums[i] = tempNumWIndex;
        }

        Arrays.sort(listOfNums);

        int head = 0;
        int end = len - 1;
        while (head < end) {
            if ((listOfNums[head].num + listOfNums[end].num) == target) {
                result[0] = listOfNums[head].index;
                result[1] = listOfNums[end].index;
                return result;
            } else if ((listOfNums[head].num + listOfNums[end].num) > target) {
                end--;
            } else {
                // (listOfNums[head].num + listOfNums[end].num) < target
                head++;
            }
        }
        return result;
    }
}
