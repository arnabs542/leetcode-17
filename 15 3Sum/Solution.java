// take advantage of twoSum, since if we use two flag scan, it only takes O(n) time
// to compute the twoSum, so that threeSum can take advantage of that fast algorithm
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (i == (nums.length - 1) || nums[i] != nums[i + 1]) {
                int currentNum = nums[i];
                List<List<Integer>> subResult = twoSum(nums, 0, i - 1, 0 - currentNum);
                if (subResult.size() > 0 && subResult.get(0).size() > 0) {
                    for(List<Integer> tempSubResult: subResult) {
                        tempSubResult.add(currentNum);
                    }
                    result.addAll(subResult);
                }
            }
        }
        return getUniqueResult(result);
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

// show all possible solutions
// most likely we need to use recursion to loop through all the possible cases
// this sulution pass 311/313 cases, the last two cases TLE
class Solution_Recursion {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return getUniqueResult(sumWith(nums, 0, nums.length - 1, 3, 0));
    }

    private List<List<Integer>> sumWith(int[] nums, int start, int end, int count, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (start > end || count <= 0 || nums.length < count) {
            return result;
        }

        if (count == 1) {
            for (int i = start; i <= end; i++) {
                int currentNum = nums[i];
                if (currentNum == target) {
                    List<Integer> subResult = new ArrayList<>();
                    subResult.add(currentNum);
                    result.add(subResult);
                    return result;
                }
            }
        }

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