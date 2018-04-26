// use recursion method in this solution
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        return getUniquePermution(nums, 0, nums.length - 1);
    }

    private List<List<Integer>> getUniquePermution(int[]nums, int start, int end) {
        if (start > end) {
            List<Integer> subResult = new ArrayList<Integer>();
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            result.add(subResult);
            return result;
        } else if (start == end) {
            List<Integer> subResult = new ArrayList<>();
            subResult.add(nums[start]);
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            result.add(subResult);
            return result;
        } else {
            List<List<Integer>> prevResults = getUniquePermution(nums, start, end - 1);
            List<List<Integer>> results = new ArrayList<>();
            Set<List<Integer>> resultSet = new HashSet<>();
            int curNum = nums[end];
            for (List<Integer> tempPrevResult: prevResults) {
                // add the curNum to the previous result to construct new result
                int len = tempPrevResult.size() + 1;
                for (int curNumPos = 0; curNumPos < len; curNumPos++) {
                    List<Integer> tempResult = new ArrayList<>(tempPrevResult);
                    tempResult.add(curNumPos, curNum);

                    // check if the result has duplication using Set
                    if (!resultSet.contains(tempResult)) {
                        resultSet.add(tempResult);
                        results.add(tempResult);
                    }
                }
            }
            return results;
        }
    }
}