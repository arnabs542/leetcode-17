// reference: http://blog.csdn.net/u014642924/article/details/72629844
// use DP method
class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        if (len1 == 0 || len2 == 0) return len1 + len2;

        // init dp array
        int[][] dp = new int[len1 + 1][len2 + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= len2; i++) dp[0][i] = 0;
        for (int i = 1; i <= len1; i++) dp[i][0] = 0;

        // calculate dp array
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                char char1 = word1.charAt(i - 1);
                char char2 = word2.charAt(j - 1);
                if (char1 == char2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        // calculate result
        return (len1 - dp[len1][len2]) + (len2 - dp[len1][len2]);
    }
}
