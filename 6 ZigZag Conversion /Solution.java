/*
Question:
https://leetcode.com/problems/zigzag-conversion/
*/

public class Solution {
    public String convert(String s, int numRows) {
    	String result = "";
    	int distance = 2 * (numRows - 1);
        if (distance == 0) distance = 1;
    	int stringLength = s.length();

        for (int row = 1; row <= numRows; row ++) {
        	if (row == 1 || row == numRows) {
        		int firstElementIndex = row - 1;
        		int elementIndex = firstElementIndex;
        		while (elementIndex < stringLength) {
        			result += s.charAt(elementIndex);
        			elementIndex += distance;
        		}
        	}
        	else {
        		int firstElementIndex = row - 1;
        		int secondElementIndex = firstElementIndex + 2 * (numRows - row);
        		int elementIndexOdd = firstElementIndex;
        		int elementIndexEven = secondElementIndex;
        		int elementIndex = elementIndexOdd;
        		while (elementIndex < stringLength) {
        			result += s.charAt(elementIndex);
        			if (elementIndex == elementIndexOdd) {
        				elementIndex = elementIndexEven;
        				elementIndexOdd += distance;
        			}
        			else {
        				elementIndex = elementIndexOdd;
        				elementIndexEven += distance;
        			}
        		}
        	}
        }

        return result;
    }
}