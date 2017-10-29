// reference: http://fisherlei.blogspot.ca/2012/12/leetcode-longest-substring-without.html
// reference: http://bangbingsyb.blogspot.ca/2014/11/leetcode-longest-substring-without.html
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // the algorithm of this solution is based on function lengthOfLongestSubstring_old
        // but with some optimization since it was timed out
        // it is because for long string indexOf may takes a lot of time
        int len = s.length();

        // quick return
        if (len == 0 || len == 1) {
            return len;
        }

        int start = 0;
        int end = 0;
        int maxSubStrLen = 0;
        Map<Character, Integer> charIdxMap = new HashMap<>();

        int temSubStringLen = 0;

        // scan from start to end of the string util meet the repeating char
        while (end < len) {
            char curChar = s.charAt(end);

            if (charIdxMap.containsKey(curChar)) {
                // current subString has repeating char and reset temp longest subString

                // update global max subString
                if (temSubStringLen > maxSubStrLen) {
                    maxSubStrLen = temSubStringLen;
                }

                // reset temp max subString
                start = charIdxMap.get(curChar) + 1;
                end = start - 1;
                charIdxMap.clear();
                temSubStringLen = 0;
            } else {
                // current subString does not have repeating char

                // update temp longest subString
                temSubStringLen++;
                charIdxMap.put(curChar, end);
            }

            end++;
        }

        // check the last subString is the longest
        if (temSubStringLen > maxSubStrLen) {
            maxSubStrLen = temSubStringLen;
        }

        return maxSubStrLen;
    }

    public int lengthOfLongestSubstring_old(String s) {
        int len = s.length();

        // quick return
        if (len == 0 || len == 1) {
            return len;
        }

        int start = 0;
        int end = 0;
        int maxSubStrLen = 0;
        Set<Character> charSet = new HashSet<>();

        int temSubStringLen = 0;
        String tempLongestSubString = "";

        // scan from start to end of the string util meet the repeating char
        while (end < len) {
            char curChar = s.charAt(end);

            if (charSet.contains(curChar)) {
                // current subString has repeating char

                // clear repeating set
                charSet.clear();

                // update global max subString
                if (temSubStringLen > maxSubStrLen) {
                    maxSubStrLen = temSubStringLen;
                }

                // reset temp max subString
                int offSet = tempLongestSubString.indexOf(curChar);
                start = start + offSet + 1;
                end = start - 1;
                temSubStringLen = 0;
                tempLongestSubString = "";
            } else {
                // current subString does not have repeating char

                // update repeating set
                charSet.add(curChar);

                // update temp longest subString
                tempLongestSubString += curChar;
                temSubStringLen++;
            }

            end++;
        }

        // check the last subString is the longest
        if (temSubStringLen > maxSubStrLen) {
            maxSubStrLen = temSubStringLen;
        }

        return maxSubStrLen;
    }
}
