public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        // set up array value and its order mapping since quick sort will change the original order
        Map<Integer, Integer> valueOrderMapping = new HashMap<Integer, Integer>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            valueOrderMapping.put(nums[i], i);
        }

        // quick sort
        Arrays.sort(nums);

        // build result array
        String[] result = new String[len];
        for (int i = 0; i < len; i++) {
            // loop through new sorted nums
            int originalOrder = valueOrderMapping.get(nums[i]);
            String rankString = getRankStringByRank(len - i);
            result[originalOrder] = rankString;
        }

        return result;
    }

    private static String getRankStringByRank(int rank) {
        if (rank == 1) {
            return "Gold Medal";
        } else if (rank == 2) {
            return "Silver Medal";
        } else if (rank == 3) {
            return "Bronze Medal";
        } else {
            return Integer.toString(rank);
        }
    }
}
