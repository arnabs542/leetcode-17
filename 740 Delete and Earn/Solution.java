class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) return 0;

        Map<Integer, Integer> numFreqMap = new HashMap<>();
        List<Integer> keysList = new ArrayList<>();

        // init number freqency record
        for (int num: nums) {
            if (numFreqMap.get(num) == null) {
                numFreqMap.put(num, 1);
                keysList.add(num);
            } else {
                numFreqMap.put(num, numFreqMap.get(num) + 1);
            }
        }

        // sort keysList
        Collections.sort(keysList);

        // use DP to calculate potential gain for each selection
        int len = keysList.size();
        int[] dp = new int[len];
        dp[0] = keysList.get(0) * numFreqMap.get(keysList.get(0));
        for (int i = 1; i < len; i++) {
            if (keysList.get(i) - keysList.get(i - 1) > 1) {
                dp[i] = dp[i - 1] + keysList.get(i) * numFreqMap.get(keysList.get(i));
            } else {
                dp[i] = Math.max((i >= 2? dp[i - 2]: 0) + keysList.get(i) * numFreqMap.get(keysList.get(i)), dp[i - 1]);
            }
        }

        return dp[len - 1];
    }
}
