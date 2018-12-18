class Solution {
    // use hash table
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> posMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(posMap.get(target - nums[i]) != null) {
                return new int[]{i, posMap.get(target - nums[i])};
            } else {
                posMap.put(nums[i], i);
            }
        }
        return new int[2];
    }

    // use sorting
    public int[] twoSum_sorting(int[] nums, int target) {
        Map<Integer, List<Integer>> posMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            List<Integer> intList;
            if(posMap.get(nums[i]) == null) {
                intList = new ArrayList<>();
                posMap.put(nums[i], intList);
            } else {
                intList = posMap.get(nums[i]);
            }
            intList.add(i);
        }

        Arrays.sort(nums);

        int start = 0;
        int end = nums.length - 1;

        while(end > start) {
            int currentSum = nums[start] + nums[end];
            if(currentSum == target) break;
            else if(currentSum > target) end--;
            else start++;
        }

        if(nums[start] != nums[end]) {
            return new int[]{posMap.get(nums[start]).get(0), posMap.get(nums[end]).get(0)};
        } else {
            return new int[]{posMap.get(nums[start]).get(0), posMap.get(nums[end]).get(1)};
        }
    }

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

    // original solution
    public int[] twoSum_original(int[] nums, int target) {
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
