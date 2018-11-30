class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) return "";

        String result = "";
        for(int i = 0; i < num2.length(); i++) {
            char curChar = num2.charAt(i);
            result = add(timesTen(result), multiply(num1, curChar));
        }
        return result;
    }

    public String add(String num1, String num2) {
        if(num1.equals("0")) return num2;
        if(num2.equals("0")) return num1;

        int carryOver = 0;
        String result = "";
        int len1 = num1.length();
        int len2 = num2.length();
        int maxLen = Math.max(len1, len2);

        for(int i = 0; i < maxLen; i++) {
            int curNum1 = 0;
            if(i < len1) {
                curNum1 = num1.charAt(len1 - 1 - i) - '0';
            }
            int curNum2 = 0;
            if(i < len2) {
                curNum2 = num2.charAt(len2 - 1 - i) - '0';
            }
            int curResult = curNum1 + curNum2 + carryOver;
            int curDigit = curResult % 10;
            carryOver = curResult / 10;
            result = Integer.toString(curDigit) + result;
        }

        if(carryOver > 0) result = "1" + result;

        return result;
    }

    public String multiply(String num1, char num2Char) {
        if(num2Char == '0') return "0";
        if(num2Char == '1') return num1;

        String result = "";
        int num2 = num2Char - '0';
        int carryOver = 0;

        for(int i = num1.length() - 1; i >= 0; i--) {
            int curNum1 = num1.charAt(i) - '0';
            int curResult = curNum1 * num2 + carryOver;
            int curDigit = curResult % 10;
            carryOver = curResult / 10;
            result = Integer.toString(curDigit) + result;
        }

        if(carryOver > 0) result = Integer.toString(carryOver) + result;

        return result;
    }

    public String timesTen(String num) {
        if(num.equals("0")) return "0";
        return num + "0";
    }
}