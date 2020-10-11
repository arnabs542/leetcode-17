class Solution {
    public int maxLength(List<String> arr) {
        // spcial case handling
        if (arr == null || arr.size() == 0) return 0;

        int[] maxLen = new int[1];
        dfs(arr, 0, "", maxLen);

        return maxLen[0];
    }

    private void dfs(List<String> arr, int start, String s, int[] maxLen) {
        // edge case handling
        if (start >= arr.size()) return;

        // check all possible cases without concat with current string
        dfs(arr, start + 1, s, maxLen);

        // check all possible cases that concat with current string
        if (canConcatWithUniqueChars(s, arr.get(start))) {
            String concatStr = s + arr.get(start);
            // update result if needed
            if (concatStr.length() > maxLen[0]) maxLen[0] = concatStr.length();

            dfs(arr, start + 1, concatStr, maxLen);
        }
    }

    // we can use bit manipulation to improve the performance of the block
    private boolean canConcatWithUniqueChars(String s1, String s2) {
        Set<Character> charSet = new HashSet<>();

        for (int i = 0; i < s1.length(); i++) {
            char tempChar = s1.charAt(i);
            if (charSet.contains(tempChar)) return false;
            charSet.add(tempChar);
        }

        for (int i = 0; i < s2.length(); i++) {
            char tempChar = s2.charAt(i);
            if (charSet.contains(tempChar)) return false;
            charSet.add(tempChar);
        }

        return true;
    }
}