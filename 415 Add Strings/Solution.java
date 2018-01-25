class Solution {
    public String addStrings(String num1, String num2) {
        List<Character> resultChars = new ArrayList<>();

        int len1 = num1.length();
        int len2 = num2.length();

        char[] chars1 = new char[len1];
        char[] chars2 = new char[len2];

        for (int i = 0; i < len1; i++) {
            chars1[i] = num1.charAt(i);
        }
        for (int i = 0; i < len2; i++) {
            chars2[i] = num2.charAt(i);
        }

        int maxLen = Math.max(len1, len2);
        int hold = 0;
        for(int i = 1; i <= maxLen; i++) {
            char char1 = (len1 - i) >= 0? chars1[len1 - i]: '0';
            char char2 = (len2 - i) >= 0? chars2[len2 - i]: '0';
            int curDigit = ((char1 - '0') + (char2 - '0') + hold) % 10;
            hold = ((char1 - '0') + (char2 - '0') + hold) / 10;
            char curDigitChar = (char)('0' + curDigit);
            resultChars.add(curDigitChar);
        }

        if (hold != 0) {
            char curDigitChar = (char)('0' + hold);
            resultChars.add(curDigitChar);
        }

        String result = "";
        for(int i = resultChars.size() - 1; i >= 0; i--) {
            result += resultChars.get(i);
        }
        return result;
    }
}
