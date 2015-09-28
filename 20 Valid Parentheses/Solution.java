/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        int length = s.length();

        for (int i = 0; i < length; i++) {
        	char c = s.charAt(i);

        	switch (c) {
        		case '(':
        			stack.push(c);
        			break;
        		case '{':
        			stack.push(c);
        			break;
        		case '[':
        			stack.push(c);
        			break;
        		case ')':
        			if (stack.empty() || !stack.peek().equals('(')) {
        				return false;
        			}
        			else {
        				stack.pop();
        			}
        			break;
        		case '}':
        			if (stack.empty() || !stack.peek().equals('{')) {
        				return false;
        			}
        			else {
        				stack.pop();
        			}
        			break;
        		case ']':
        			if (stack.empty() || !stack.peek().equals('[')) {
        				return false;
        			}
        			else {
        				stack.pop();
        			}
        			break;
        		default:
        			break;
        	}
        }

        if (stack.empty()) {
        	return true;	
        }
        else {
        	return false;
        }
    }
}