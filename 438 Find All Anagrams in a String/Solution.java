class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int pLen = p.length();
        int sLen = s.length();

        if (sLen < pLen) return result;

        Map<Character, Integer> charStatP = getCharStat(p);
        Map<Character, Integer> charStatS = getCharStat(s.substring(0, pLen));

        for(int i = 0; i <= sLen - pLen; i++) {
            if (i != 0) {
                // update char star
                char prevChar = s.charAt(i - 1);
                char latestChar = s.charAt(i + pLen - 1);
                if (prevChar != latestChar) {
                    int prevCharCount = charStatS.get(prevChar);
                    if (prevCharCount > 1) {
                        charStatS.put(prevChar, prevCharCount - 1);
                    } else {
                        charStatS.remove(prevChar);
                    }
                    if (charStatS.get(latestChar) == null) {
                        charStatS.put(latestChar, 1);
                    } else {
                        charStatS.put(latestChar, charStatS.get(latestChar) + 1);
                    }
                }
            }

            if (isEqualCharStat(charStatS, charStatP)) result.add(i);
        }
        return result;
    }

    private Map<Character, Integer> getCharStat(String p) {
        Map<Character, Integer> charStat = new HashMap<>();
        for(int i = 0; i < p.length(); i++) {
            char curChar = p.charAt(i);
            if (charStat.get(curChar) != null) {
                charStat.put(curChar, charStat.get(curChar) + 1);
            } else {
                charStat.put(curChar, 1);
            }
        }
        return charStat;
    }

    private boolean isEqualCharStat(Map<Character, Integer> a, Map<Character, Integer> b) {
        int aKeyLen = a.keySet().size();
        int bKeyLen = b.keySet().size();

        if (aKeyLen != bKeyLen) return false;

        for(char aChar: a.keySet()) {
            if (b.get(aChar) == null) return false;
            if (a.get(aChar).intValue() != b.get(aChar).intValue()) return false;
        }

        return true;
    }
}