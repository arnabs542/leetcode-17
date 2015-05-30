/*
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/

public class Solution {
    public int strStr(String haystack, String needle) {
        int haystackLength = haystack.length();
        int needleLength = needle.length();

        if (needleLength == 0) return 0;
        if (haystackLength <  needleLength || haystackLength == 0) return -1;

        int[] kmp = getKMPArray(needle);
        int j = 0;
        int i = 0;

    	while (i < haystackLength) {
            while (i < haystackLength && j < needleLength && haystack.charAt(i) == needle.charAt(j)) {
                i ++;
                j ++;
                if (j == needleLength) return (i - j);
            }

            if (i < haystackLength && j != 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = kmp[j - 1];
            }

            if (i < haystackLength && j == 0 && haystack.charAt(i) != needle.charAt(j)) {
                i ++;
            }
        }

        return -1;
    }

    public int[] getKMPArray (String s) {
        int length = s.length();
        int[] kmp = new int[length];
        int j = 0;

        kmp[0] = j;

        for (int i = 1; i < length; i ++) {
            if (s.charAt(i) == s.charAt(j)) j ++;            
            else while (s.charAt(i) != s.charAt(j) && j != 0) {
                j = kmp[j];
                if (j == kmp[j]) j = 0;
            }
            kmp[i] = j;
        }

        return kmp;
    }   

    public int[] getKMPArray_BadOne (String s) {
        int length = s.length();
        int[] kmp = new int[length];

        kmp[0] = 0;

        for (int i = 1; i < length; i ++) {
            int counter = 0;
            String sTemp = s.substring(0, (i + 1));

            String[] prefix = getPrefix(sTemp);
            String[] suffix = getSuffix(sTemp);

            for (int j = 0; j < prefix.length; j ++) {
                if (prefix[j].equals(suffix[prefix.length - 1 - j]));
                counter ++;
            }

            kmp[i] = counter;
        }

        return kmp;
    }

    public String[] getPrefix (String s) {
        int length = s.length();
        String[] prefix = new String[length - 1];

        for (int i = 0; i < (length - 1); i ++) {
            prefix[i] = s.substring(0, (i + 1));
        }

        return prefix;
    }

    public String[] getSuffix (String s) {
        int length = s.length();
        String[] suffix = new String[length - 1];

        for (int i = 0; i < (length - 1); i ++) {
            suffix[i] = s.substring((i + 1), length);
        }

        return suffix;
    }
}