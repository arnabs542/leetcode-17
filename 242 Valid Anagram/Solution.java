/*
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.
*/

public class Solution {
    public boolean isAnagram(String s, String t) {
    	if (s.equals("") && t.equals("")) {
    		return true;
    	}

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return isEqualChars(sChars, tChars);
    }

    private boolean isEqualChars (char[] chars1, char[] chars2) {
    	if (chars1.length != chars2.length) {
    		return false;
    	}

    	int length = chars1.length;

    	for (int i = 0; i < length; i ++) {
    		if (chars1[i] != chars2[i]) {
    			return false;
    		}
    	}

    	return true;
    }
}