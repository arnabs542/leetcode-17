class Solution {
    // use DP to solve the problem, we can build recursion expression of the result
    // dp[i][j] means the longest palindrome sub-string from index i to j of the string
    // if s[i] = s[j], dp[i][j] = dp[i+1][j-1] + 2
    // otherwise, dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])
    // Initialization: dp[i][i] = 1
    // ref: https://leetcode.com/problems/longest-palindromic-subsequence/discuss/99101/Straight-forward-Java-DP-solution
    public int longestPalindromeSubseq(String s) {
        // special case handling
        if (s == null || s.length() == 0) return 0;

        int len = s.length();
        int[][] dp = new int[len][len];

        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // find a new pair for current char to add to palindrome substring
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    // cannot find a new pair for current char
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][len - 1];
    }
}