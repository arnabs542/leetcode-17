class Solution {
    // use recursion
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return subsetsWithDup(nums, 0, nums.length - 1);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums, int start, int end) {
        if (start > end) {
            List<List<Integer>> reuslt = new ArrayList<>();
            // add empty array
            reuslt.add(new ArrayList<Integer>());
            return reuslt;
        }

        if (start == end) {
            List<List<Integer>> reuslt = new ArrayList<>();
            // add empty array
            reuslt.add(new ArrayList<Integer>());
            // add result with single element
            List<Integer> subResult = new ArrayList<>();
            subResult.add(nums[0]);
            reuslt.add(subResult);
            return reuslt;
        }

        // start > end
        List<List<Integer>> preReuslt = subsetsWithDup(nums, start, end - 1);
        List<List<Integer>> preReusltCopy = deepCopy(preReuslt);
        List<List<Integer>> reuslt = new ArrayList(preReusltCopy);
        int curNum = nums[end];
        for (List<Integer> tempResult: preReuslt) {
            tempResult.add(curNum);
        }
        reuslt.addAll(preReuslt);
        reuslt = new ArrayList(new HashSet(reuslt));
        return reuslt;
    }

    private List<List<Integer>> deepCopy(List<List<Integer>> toCopy) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> subToCopy: toCopy) {
            List<Integer> subResult = new ArrayList<>();
            for (int tempInt: subToCopy) {
                subResult.add(tempInt);
            }
            result.add(subResult);
        }
        return result;
    }
}