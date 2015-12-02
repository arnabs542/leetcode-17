/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/

public class Solution {
    public List<String> letterCombinations(String digits) {
    	List<String> result = new ArrayList<String>();
        int length = digits.length();

        if (length == 0) {
        	return result;
        }

        if (length == 1) {
        	return mapping(Character.getNumericValue(digits.charAt(0)));
        }

        String subDigits = digits.substring(0, length - 1);
        char lastChar = digits.charAt(length - 1);

        List<String> subResult = letterCombinations(subDigits);
        List<String> curResult = mapping(Character.getNumericValue(lastChar));

        for (String s1: curResult) {
        	List<String> resultTemp = new ArrayList<String>();
        	for (String s2: subResult) {
        		s2 += s1;
        		resultTemp.add(s2);
        	}
        	result.addAll(resultTemp);
        }

        return result;
    }

    private List<String> mapping (int input) {
    	List<String> result = new ArrayList<String>();

    	if (input == 1) {
    		return result;
    	}

    	if (input == 2) {
    		result.add("a");
    		result.add("b");
    		result.add("c");
    		return result;
    	}

    	if (input == 3) {
    		result.add("d");
    		result.add("e");
    		result.add("f");
    		return result;
    	}

    	if (input == 4) {
    		result.add("g");
    		result.add("h");
    		result.add("i");
    		return result;
    	}

    	if (input == 5) {
    		result.add("j");
    		result.add("k");
    		result.add("l");
    		return result;
    	}

    	if (input == 6) {
    		result.add("m");
    		result.add("n");
    		result.add("o");
    		return result;
    	}

    	if (input == 7) {
    		result.add("p");
    		result.add("q");
    		result.add("r");
    		result.add("s");
    		return result;
    	}

    	if (input == 8) {
    		result.add("t");
    		result.add("u");
    		result.add("v");
    		return result;
    	}

    	if (input == 9) {
    		result.add("w");
    		result.add("x");
    		result.add("y");
    		result.add("z");
    		return result;
    	}

    	return result;
    }
}