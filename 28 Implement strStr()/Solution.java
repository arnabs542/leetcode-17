/*
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/

public class Solution {
    public int strStr(String haystack, String needle) {
    	int haystackLength = haystack.length();
    	int needleLength = needle.length();
    	
    	if (needleLength == 0) return 0;
        if (haystackLength == 0 || haystackLength < needleLength) return -1;

        for (int i = 0; i < haystackLength; i ++) {
        	int matchIndex = 0;
        	while (matchIndex < needleLength && (i + matchIndex) < haystackLength && haystack.charAt(i + matchIndex) == needle.charAt(matchIndex)) {
        		matchIndex ++;
        		if (matchIndex == needleLength) return i;
        	}
        }

        return -1;
    }
}