/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/

public class Solution {
    public String countAndSay(int n) {
        String s = "1";

        if (n == 0) {
        	return "";
        }

        if (n == 1) {
        	return s;
        }

        for (int i = 2; i <= n; i ++) {
        	s = nextString(s);
        }

        return s;
    }

    private String nextString (String s) {
    	int length = s.length();
    	String result = "";

    	for (int i = 0; i < length; i ++) {
    		char curChar = s.charAt(i);
    		int counter = 1;
    		while ((i + 1) < length && s.charAt(i + 1) == curChar) {
    			i ++;
    			counter ++;
    		}
    		result += counter;
    		result += curChar;
    	}

    	return result;
    }
}