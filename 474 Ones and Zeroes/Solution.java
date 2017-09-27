// reference: http://bookshadow.com/weblog/2016/12/11/leetcode-ones-and-zeroes/
// reference: http://www.cnblogs.com/grandyang/p/6188893.html

// thoughts: DP!
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (String s : strs) {
            int zero = 0, one = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') zero++;
                if (s.charAt(i) == '1') one++;
            }
            for (int i = m; i > zero - 1; i--) {
                for (int j = n; j > one - 1; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int maxForm;

    public int _findMaxForm(String[] strs, int m, int n) {
        maxForm = -1;

        int len = strs.length;
        int[] ms = new int[len];
        int[] ns = new int[len];

        for (int i = 0; i < len; i++) {
            ms[i] = 0;
            ns[i] = 0;
            String s = strs[i];
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '0') ms[i]++;
                if (c == '1') ns[i]++;
            }
        }

        Set<Integer> visited = new HashSet<>();

        loopAllCases(ms, ns, m, n, visited, 0, len);

        return maxForm;
    }

    private void loopAllCases(int[] ms, int[] ns, int m, int n, Set<Integer> visited, int startPos, int endPos) {
        if (startPos < endPos) {
            loopAllCases(ms, ns, m, n, visited, startPos + 1, endPos);

            visited.add(startPos);
            loopAllCases(ms, ns, m, n, visited, startPos + 1, endPos);
            visited.remove(startPos);
        } else if (startPos == endPos) {
            if (visited.size() > maxForm) {
                int maxFormTemp = getMaxForm(ms, ns, m, n, visited);
                if (maxFormTemp > maxForm) maxForm = maxFormTemp;
            }
        }
    }

    private int getMaxForm(int[] ms, int[] ns, int m, int n, Set<Integer> visited) {
        int mSum = 0;
        int nSum = 0;
        for (int pos: visited) {
            nSum += ns[pos];
            mSum += ms[pos];
            if (mSum > m || nSum > n) return 0;
        }
        return visited.size();
    }
}
