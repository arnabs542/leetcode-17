// use recursion, make full use of the previous sub-result
// construct results based on previous sub-result
// the key is to come up with the recursion formula
class Solution {
    public String longestPalindrome(String s) {
        // deal with basic cases for recursion
        int len = s.length();
        if (len == 1) return s;

        // get sub-results
        String subLongestPalindrome = longestPalindrome(s.substring(0, len - 1));

        // compare sub-results with results with new added elements
        // update the result if needed
        int maxPalindromeLen = subLongestPalindrome.length();
        if (maxPalindromeLen + 2 <= len) {
            String substringIncludingLastChar = s.substring(len - (maxPalindromeLen + 2));
            if (isPalindrome(substringIncludingLastChar)) return substringIncludingLastChar;
        }
        if (maxPalindromeLen + 1 <= len) {
            String substringIncludingLastChar = s.substring(len - (maxPalindromeLen + 1));
            if (isPalindrome(substringIncludingLastChar)) return substringIncludingLastChar;
        }

        // otherwise return sub-results
        return subLongestPalindrome;
    }

    public boolean isPalindrome(String s) {
        int len = s.length();
        if (len == 1) return true;
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}