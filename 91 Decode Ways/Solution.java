// reference: https://www.jianshu.com/p/edd9da18eb01
// use DP if it just wants to get the count of different combinations
// otherwise try recursion

class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if (len <= 0) return 0;

        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = (s.charAt(0) == '0') ? 0 : 1;

        for (int i = 2; i <= len; i++) {
            int lastDigit = Integer.valueOf(s.substring(i-1,i));
            int lastTwoDigits = Integer.valueOf(s.substring(i-2,i));

            if (lastDigit >= 1 && lastDigit <= 9) {
                dp[i] += dp[i - 1];
            }
            if (lastTwoDigits >= 10 && lastTwoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[len];
    }

    /* Old DP method, very bad, just ignore it
    public int numDecodings(String s) {
        int len = s.length();
        int[] digits = new int[len];

        for (int i = 0; i < len; i++) {
            digits[i] = Character.getNumericValue(s.charAt(i));
        }

        return numDecodings(digits, 0, len - 1);
    }

    public int numDecodings(int[] digits, int start, int end) {
        int len = digits.length;

        // invalid cases
        if (start > end || end > len) return 0;

        // only one characters
        if (start == end) {
            if (isValidChar(digits[end])) return 1;
            else return 0;
        }

        int curDigit = digits[end];
        int preDigit = digits[end - 1];
        int preResult;

        // deal with that current digit is 0
        if (curDigit == 0) {
            if (isValidChar(10 * preDigit)) {
                preResult = numDecodings(digits, start, end - 2);
                if (preResult == 0) return 1;
                else return preResult;
            } else {
                return 0;
            }
        }

        // deal with that current digit is not 0
        // count that current digit as single digit
        preResult = numDecodings(digits, start, end - 1);
        int curResult = preResult;

        // if previous result is 0 and it is not empty digit, return 0
        if (preResult == 0 && end - 1 >= 0) return 0;

        // combination of current digit and previous digit can be another choice
        int prepreResult = numDecodings(digits, start, end - 2);
        if ((end - 2) < 0) prepreResult = 1;
        if (preDigit != 0 && isValidChar(10 * preDigit + curDigit)) {
            curResult += prepreResult;
        }

        return curResult;
    }

    public boolean isValidChar(int number) {
        return number >= 1 && number <= 26;
    }
    */
}
