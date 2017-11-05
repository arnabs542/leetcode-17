class Solution {
    public String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        int lenMax = Math.max(lenA, lenB);
        String result = "";

        int carry = 0;
        for (int count = 0; count < lenMax; count++) {
            // compare every digit of A and B, add them up
            int intA = 0;
            int intB = 0;

            if (lenA > count) {
                intA = Character.getNumericValue(a.charAt(lenA - 1 - count));
            }

            if (lenB > count) {
                intB = Character.getNumericValue(b.charAt(lenB - 1 - count));
            }

            // update carry & current result
            int tempResult = (intA + intB + carry) % 2;
            carry = (intA + intB + carry) / 2;
            result = tempResult + result;
        }

        if (carry != 0) {
            result = "1" + result;
        }

        return result;
    }
}
