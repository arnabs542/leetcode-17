class Solution {
    private class ComplexNumber {
        private int a;
        private int b;

        ComplexNumber(String s) {
            String[] sArray = s.split("\\+", 2);
            this.a = Integer.parseInt(sArray[0]);
            this.b = Integer.parseInt(sArray[1].substring(0, sArray[1].length() - 1));
        }

        ComplexNumber(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public ComplexNumber muliply(ComplexNumber complexNum) {
            return new ComplexNumber(this.a * complexNum.a - this.b * complexNum.b, this.a * complexNum.b + this.b * complexNum.a);
        }

        public String toString() {
            return Integer.toString(this.a) + "+" + Integer.toString(this.b) + "i";
        }
    }

    public String complexNumberMultiply(String a, String b) {
        ComplexNumber complexNumA = new ComplexNumber(a);
        ComplexNumber complexNumB = new ComplexNumber(b);
        ComplexNumber complexNumResult = complexNumA.muliply(complexNumB);
        return complexNumResult.toString();
    }
}
