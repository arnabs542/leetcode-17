class Solution {
    public boolean isSubsequence(String s, String t) {
        int lenT = t.length();
        int lenS = s.length();

        int cursorT = 0;
        int cursorS = 0;

        while (cursorS < lenS && cursorT < lenT) {
            char curCharT = t.charAt(cursorT);
            char curCharS = s.charAt(cursorS);
            if (curCharT == curCharS) {
                cursorS++;
            }
            cursorT++;
        }

        return cursorS == lenS;
    }
}
