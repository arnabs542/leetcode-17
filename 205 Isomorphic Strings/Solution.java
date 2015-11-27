/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.
*/

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int sizeS = s.length();
        int sizeT = t.length();

        if (sizeS != sizeT) {
        	return false;
        }

        Map<Character, Character> map = new HashMap<Character, Character>();

        for (int i = 0; i < sizeS; i ++) {
        	char charS = s.charAt(i);
        	char charT = t.charAt(i);

        	if (map.get(charS) == null) {
        		if (map.containsValue(charT)) {
        			return false;
        		}
        		else {
        			map.put(charS, charT);
        		}
        	}
        	else {
        		if (map.get(charS) != charT) {
        			return false;
        		}
        	}
        }

        return true;
    }
}