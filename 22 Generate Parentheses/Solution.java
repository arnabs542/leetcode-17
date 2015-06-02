/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/

//Reference: http://fisherlei.blogspot.ca/2012/12/leetcode-generate-parentheses.html

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        String temp = "(";

        if (n == 0) return result;

        genParenthesis(result, temp, n - 1, n);

        return result;
    }

    //use regression method
    private void genParenthesis(List<String> result, String temp, int leftLeft, int rightLeft) {
    	if (leftLeft <= rightLeft && leftLeft >= 0) {
    		if (leftLeft == 0 && rightLeft == 0) {
    			result.add(temp);

    			return;
    		}

    		if (leftLeft > 0) {
    			String tempL = temp + "(";
    			genParenthesis(result, tempL, (leftLeft - 1), rightLeft);
    		}

    		if (rightLeft > 0) {
    			String tempR = temp + ")";
    			genParenthesis(result, tempR, leftLeft, (rightLeft - 1));
    		}
    	}
    }
}