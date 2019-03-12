// recursion
class Solution {
    public int longestValidParentheses(String s) {
        int len = s.length();
        if(len == 0 || len == 1) return 0;
        if(s.equals("()")) return 2;

        char lastChar = s.charAt(len - 1);
        if(lastChar == '(') {
            return longestValidParentheses(s.substring(0, len - 1));
        } else {
            int maxLenWoCurrentChar = longestValidParentheses(s.substring(0, len - 1));
            int maxLenWCurrentChar = getLongestValidParentheseWLastChar(s.substring(0, len));
            return Math.max(maxLenWoCurrentChar, maxLenWCurrentChar);
        }
    }

    private int getLongestValidParentheseWLastChar(String s) {
        int len = s.length();
        if(len == 0 || len == 1) return 0;
        if(s.substring(len - 2, len).equals("()")) return getLongestValidParentheseWLastChar(s.substring(0, len - 2)) + 2;

        int max = 0;
        int curMaxLen = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = len - 1; i >= 0; i--) {
            char curChar = s.charAt(i);
            if(curChar == ')') {
                stack.push(curChar);
            } else if(curChar == '('){
                if(stack.empty()) {
                    return curMaxLen;
                } else {
                    stack.pop();
                    curMaxLen += 2;
                    if(stack.empty()) max = curMaxLen;
                }
            }
        }

        return max;
    }
}