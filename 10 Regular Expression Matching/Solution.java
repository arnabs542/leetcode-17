class Solution {
    // use recursion
    public boolean isMatch(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();

        if (lenP == 0) {
            return lenS == 0;
        }

        if (lenP == 1) {
            return lenS == 1 && (s.equals(p) || p.equals("."));
        }

        // lenP > 1
        char lastP = p.charAt(lenP - 1);
        if (lastP == '.') {
            return lenS > 0 && isMatch(s.substring(0, lenS - 1), p.substring(0, lenP - 1));
        }

        if (lastP == '*') {
            char lastlastP = p.charAt(lenP - 2);
            for (int i = lenS; i >= 0; i--) {
                if (lastlastP != '.' && i != lenS && s.charAt(i) != lastlastP) {
                    break;
                }
                if (isMatch(s.substring(0, i), p.substring(0, lenP - 2))){
                    return true;
                }
            }
            return false;
        }

        return lenS > 0 && s.charAt(lenS - 1) == lastP && isMatch(s.substring(0, lenS - 1), p.substring(0, lenP - 1));
    }
}