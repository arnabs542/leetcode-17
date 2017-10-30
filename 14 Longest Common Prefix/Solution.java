class Solution {
    public String longestCommonPrefix(String[] strs) {
        int curPos = 0;
        int numOfStr = strs.length;
        String commonPrefix = "";

        // quick return
        if (numOfStr == 0) return "";
        if (numOfStr == 1) return strs[0];

        // check all strings if the current prefix applies
        while (true) {
        	char curChar;
            if (strs[0].length() > curPos) {
                curChar = strs[0].charAt(curPos);
            } else {
                return commonPrefix;
            }

            for (int i = 1; i < numOfStr; i++) {
                if (strs[i].length() > curPos) {
                    char tempChar = strs[i].charAt(curPos);
                    if (tempChar != curChar) {
                        return commonPrefix;
                    }
                } else {
                    return commonPrefix;
                }

            }
            curPos++;
            commonPrefix += curChar;
        }
    }
}
