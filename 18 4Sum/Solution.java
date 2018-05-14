class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return getUniqueResult(sumWith(nums, 0, nums.length - 1, 4, target));
    }

    private List<List<Integer>> sumWith(int[] nums, int start, int end, int count, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (start > end || count <= 0 || nums.length < count) {
            return result;
        }

        if (count == 1) {
            return oneSum(nums, start, end, target);
        } else if (count == 2) {
            return twoSum(nums, start, end, target);
        } else {
            // count is more than 2
            // try each combination to see if the result contains current number or not
            for (int i = end; i >= start + count - 1; i--) {
                int currentNum = nums[i];
                // result with current number
                List<List<Integer>> resultWithCurrentNum = sumWith(nums, start, i - 1, count - 1, target - currentNum);
                if (resultWithCurrentNum.size() > 0 && resultWithCurrentNum.get(0).size() > 0) {
                    for(List<Integer> tempResultWithCurrentNum: resultWithCurrentNum) {
                        tempResultWithCurrentNum.add(currentNum);
                    }
                    result.addAll(resultWithCurrentNum);
                }
            }
            return result;
        }
    }

    private List<List<Integer>> oneSum(int[] nums, int start, int end, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = start; i <= end; i++) {
            int currentNum = nums[i];
            if (currentNum == target) {
                if (!set.contains(currentNum)) {
                    List<Integer> subResult = new ArrayList<>();
                    subResult.add(currentNum);
                    result.add(subResult);
                    set.add(currentNum);
                }
            }
        }
        return result;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int end, int target) {
        List<List<Integer>> result = new ArrayList<>();
        while (start < end) {
            if ((nums[start] + nums[end]) == target) {
                List<Integer> subResult = new ArrayList<>();
                subResult.add(nums[start]);
                subResult.add(nums[end]);
                result.add(subResult);
                start++;
                end--;
            } else if ((nums[start] + nums[end]) < target) {
                start++;
            } else {
                end--;
            }
        }
        return result;
    }

    private List<List<Integer>> getUniqueResult(List<List<Integer>> lists) {
        Set<List<Integer>> setList = new HashSet<>();
        for (List<Integer> tempList: lists) {
            setList.add(tempList);
        }
        List<List<Integer>> result = new ArrayList<>();
        result.addAll(setList);
        return result;
    }
}