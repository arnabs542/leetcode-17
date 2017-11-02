class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> tempResult = combinationSumHelp(candidates, 0, candidates.length - 1, target);
        return new ArrayList(tempResult);
    }

    public Set<List<Integer>> combinationSumHelp(int[] candidates, int start, int end, int target) {
        if (end >= start) {
            int curVal = candidates[end];
            Set<List<Integer>> result = combinationSumHelp(candidates, start, end - 1, target);
            if (curVal <= target) {
                Set<List<Integer>> oldResult = combinationSumHelp(candidates, start, end - 1, target - curVal);
                if (oldResult.size() > 0) {
                    for (List<Integer> resultItem: oldResult) {
                        resultItem.add(curVal);
                    }
                }
                if (curVal == target) {
                    List<Integer> tempResultItem = new ArrayList<>();
                    tempResultItem.add(curVal);
                    oldResult.add(tempResultItem);
                }
                result.addAll(oldResult);
            }
            return result;
        } else {
            return new HashSet<List<Integer>>();
        }
    }
}
