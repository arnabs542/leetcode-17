class Solution {
    public int myAtoi(String str) {
        String strWithoutLeadingWhiteSpace = trimLeadingWhiteSpace(str);

        boolean isNegative = false;
        long result = 0;

        int len = strWithoutLeadingWhiteSpace.length();
        for (int i = 0; i < len; i++) {
            char curChar = strWithoutLeadingWhiteSpace.charAt(i);
            if (curChar == '+') {
                if (i != 0) {
                    break;
                }
            } else if (curChar == '-') {
                if (i == 0) {
                    isNegative = true;
                } else {
                    break;
                }
            } else if (isNumber(curChar)) {
                int curNum = getNumber(curChar);
                if (isNegative) {
                    result = result * 10 - (long)curNum;
                } else {
                    result = result * 10 + (long)curNum;
                }
            } else {
                break;
            }

            if (result >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (result <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        return (int)result;
    }

    private String trimLeadingWhiteSpace(String s) {
        char WHITE_SPACE = ' ';
        int len = s.length();
        int whiteSpaceEndPos = -1;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == WHITE_SPACE) {
                whiteSpaceEndPos = i;
            } else {
                break;
            }
        }
        return s.substring(whiteSpaceEndPos + 1);
    }

    private boolean isNumber(char c) {
        switch(c) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return true;
            default:
                return false;
        }
    }

    private int getNumber(char c) {
        return c - '0';
    }
}