class Solution {
    // DP
    public boolean isMatch(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();

        // init dp array
        boolean[][] dp = new boolean[lenS + 1][lenP + 1];
        for (int i = 0; i <= lenS; i++) {
            for (int j = 0; j <= lenP; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && (p.charAt(j - 1) == '*');
                } else {
                    dp[i][j] = false;
                }
            }
        }

        // fill in dp array
        for (int i = 1; i <= lenS; i++) {
            for (int j = 1; j <= lenP; j++) {
                char charS = s.charAt(i - 1);
                char charP = p.charAt(j - 1);
                if (charS == charP) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (charP == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (charP == '*') {
                    for (int k = i; k >= 0; k--) {
                        if (dp[k][j - 1]) {
                            dp[i][j] = true;
                            break;
                        }
                    }
                }
            }
        }

        return dp[lenS][lenP];
    }

    // recursion - This solution will time out
    public boolean isMatch_Recursion(String s, String p) {
        int lenP = p.length();
        int lenS = s.length();

        if (lenP == 0) return lenS == 0;

        char lastPChar = p.charAt(lenP - 1);
        if (lastPChar == '?') {
            if (lenS == 0) return false;
            else return isMatch(s.substring(0, lenS - 1), p.substring(0, lenP - 1));
        } else if (lastPChar == '*') {
            for (int i = 0; i <= lenS; i++) {
                if (isMatch(s.substring(0, lenS - i), p.substring(0, lenP - 1))) return true;
            }
            return false;
        } else {
            // lastPChar is a-z
            if (lenS == 0) {
                return false;
            } else {
                char lastSChar = s.charAt(lenS - 1);
                if (lastPChar == lastSChar) {
                    return isMatch(s.substring(0, lenS - 1), p.substring(0, lenP - 1));
                } else {
                    return false;
                }
            }
        }
    }
}