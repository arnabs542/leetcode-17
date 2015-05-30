/*
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/

//reference: http://literacy.kent.edu/Minigrants/Cinci/romanchart.htm

/*
I:1 V:5 X:10 L:50 C:100 D:500 M:1000
*/

public class Solution {
    public String intToRoman(int num) {
    	String result = "";
        Map<Integer, Character> numToRoman = new HashMap<Integer, Character>();

        numToRoman.put(1, 'I');
        numToRoman.put(5, 'V');
        numToRoman.put(10, 'X');
        numToRoman.put(50, 'L');
        numToRoman.put(100, 'C');
        numToRoman.put(500, 'D');
        numToRoman.put(1000, 'M');

        int[] nums = {1, 5, 10, 50, 100, 500, 1000};
        int length = nums.length;

        for (int i = (length - 1); i >= 0; i --) {
        	int numTemp = nums[i];
        	
        	//numTemp = 1, 10 ,100, 1000
        	if ((i % 2) == 0) {
        		int count = num / numTemp;
            	if (count < 4) {
            		for (int j = 0; j < count; j ++) {
            			result += numToRoman.get(numTemp);
            		}
            	}
            	else if (count == 4) {
            		result += numToRoman.get(numTemp);
            		result += numToRoman.get(numTemp * 5);
            	}
            	
            	num -= numTemp * count;
        	}
        	//numTemp = 5, 50, 500
        	else {
        		if ((num / (numTemp / 5)) == 9) {
        			result += numToRoman.get(numTemp / 5);
        			result += numToRoman.get(numTemp * 2);
        			num -= numTemp / 5 * 9;
        		}
        		else {
        			int count = num / numTemp;
        			if (count == 1) {
        				result += numToRoman.get(numTemp);
        				num -= numTemp;
                	}
        		}
        	}
        }

        return result;
    }
}