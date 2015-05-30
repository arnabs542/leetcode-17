/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/

//reference: http://literacy.kent.edu/Minigrants/Cinci/romanchart.htm

/*
I:1 V:5 X:10 L:50 C:100 D:500 M:1000
*/

public class Solution {
    public int romanToInt(String s) {
    	int result = 0;
        Map romanToNum = new HashMap();

        romanToNum.put('I', 1);
        romanToNum.put('V', 5);
        romanToNum.put('X', 10);
        romanToNum.put('L', 50);
        romanToNum.put('C', 100);
        romanToNum.put('D', 500);
        romanToNum.put('M', 1000);

        int length = s.length();
        for (int i = 0; i < length; i ++) {
        	char currentChr = s.charAt(i);
        	int currentNum = (int) romanToNum.get(currentChr);

        	if (i < (length - 1)) {
        		char nextChar = s.charAt(i + 1);
        		int nextNum = (int) romanToNum.get(nextChar);

        		if (currentNum < nextNum) {
        			result -= currentNum;
        		}
        		else {
        			result += currentNum;
        		}
        	}
        	else {
        		result += currentNum;
        	}
        }

        return result;
    }
}