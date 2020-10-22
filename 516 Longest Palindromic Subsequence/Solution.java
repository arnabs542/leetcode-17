class Solution {
    // use DP to solve the problem, we can build recursion expression of the result
    // dp[i][j] means the longest palindrome sub-string from index i to j of the string
    // dp[i][j] = max(dp[i][j - 1], dp[k][j - 1] + 2)
    // (k is the first index after the first character that is equal to s[j] between i to j - 1)
    public int longestPalindromeSubseq(String s) {
        // special case handling
        if (s == null || s.length() == 0) return 0;

        int len = s.length();
        int[][] dp = new int[len][len];

        // set default value for dp array
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                dp[i][j] = 1;
            }
        }

        for (int j = 1; j < len; j++) {
            for (int i = j - 1; i >= 0; i--) {
                char curChar = s.charAt(j);
                int k = s.substring(i, j).indexOf(curChar);
                if (k == -1) {
                    // cannot find a new pair for current char
                    if (j > 0) dp[i][j] = dp[i][j - 1];
                } else {
                    k += i;
                    // find a new pair for current char to add to palindrome substring
                    dp[i][j] = Math.max(dp[i][j - 1], dp[k + 1][j - 1] + 2);
                }
            }
        }

        return dp[0][len - 1];
    }
}