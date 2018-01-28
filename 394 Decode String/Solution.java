class Solution {
    public String decodeString(String s) {
        String result = "";
        int repeat = 0;

        int subStrStackDepth = 0;
        int subStrStart = 0;

        // parse the string
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char curChar = s.charAt(i);

            if (isEnChar(curChar) && subStrStackDepth == 0) {
                result = result + curChar;
            }

            if (curChar >= '0' && curChar <= '9' && subStrStackDepth == 0) {
                repeat = repeat * 10 + (int)(curChar - '0');
            }

            if (curChar == '[') {
                if (subStrStackDepth == 0) subStrStart = i + 1;
                subStrStackDepth++;
            }

            if (curChar == ']') {
                subStrStackDepth--;
                if (subStrStackDepth == 0) {
                    String subStringPattern = s.substring(subStrStart, i);
                    String subString = decodeString(subStringPattern);
                    for (int j = 0; j < repeat; j++) {
                        result = result + subString;
                    }

                    // reset the repeat times and the repeat string pattern
                    repeat = 0;
                }
            }
        }

        return result;
    }

    private boolean isEnChar(char c) {
        return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'));
    }
}
