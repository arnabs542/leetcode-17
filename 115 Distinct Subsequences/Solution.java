/*
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
*/

// It seems like a complicated problem. We can use recursion to solve this problem.
// For recursion, the most crucial thing is to come up with the correct expression to describle the problem.
// Thus, we can think how to solve the current problem if we already know the answer to the subproblem.

// Reference: http://fisherlei.blogspot.ca/2012/12/leetcode-distinct-subsequences_19.html

public class Solution {
	// DP solution with complexity of O(mn)
	public int numDistinct(String s, String t) {
		int sLen = s.length();
        int tLen = t.length();

        if (sLen == 0 || tLen == 0) {
        	return 0;
        }

        int[][] r = new int[sLen][tLen];

        for (int i = 0; i < sLen; i ++) {
        	for (int j = 0; j < tLen; j ++) {
        		if (i < j) {
        			r[i][j] = 0;
        		}
        		else {
        			// the last character of string s
		        	char sChar = s.charAt(i);
		        	// the last character of string t
		        	char tChar = t.charAt(j);

		        	// DP expression handling
		        	if (sChar == tChar) {
		        		if (i == 0) {
		        			r[i][j] = 1;
		        		}
		        		else if (j == 0) {
		        			r[i][j] = r[i - 1][j] + 1;
		        		}
		        		else {
		        			r[i][j] = r[i - 1][j - 1] + r[i - 1][j];
		        		}
		        	}
		        	else {
		        		if (i == 0) {
		        			r[i][j] = 0;
		        		}
		        		else {
		        			r[i][j] = r[i - 1][j];
		        		}
		        	}
        		}
        	}
        }

        return r[sLen - 1][tLen - 1];
	}

	// This solution is correct but got Time Limit Exceeded since we use recursion. It took too much time.
	// For this issue, we can switch to DP to solve the time limit problem.
    public int numDistinct_LimitedTimeError(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if (sLen == 0 || tLen == 0) {
        	return 0;
        }

        if (sLen < tLen) {
        	return 0;
        }
        else if (sLen == tLen) {
        	if (s.equals(t)) {
        		return 1;
        	}
        	else {
        		return 0;
        	}
        }
        // recursion
        else {
        	// the last character of string s
        	char sLastChar = s.charAt(sLen - 1);
        	// the last character of string t
        	char tLastChar = t.charAt(tLen - 1);

        	if (sLastChar == tLastChar) {
        		String subS = s.substring(0, sLen - 1);
        		String subT = t.substring(0, tLen - 1);
        		return numDistinct(subS, subT) + numDistinct(subS, t);
        	}
        	else {
        		String subS = s.substring(0, sLen - 1);
        		return numDistinct(subS, t);
        	}
        }
    }
}