class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // simulate how human calculate the result
        StringBuilder sb = new StringBuilder();

        // special result
        if (numerator == 0) return "0";

        // convert int to long in case of overflow
        long newNumerator = (long) numerator;
        long newDenominator = (long) denominator;

        // check if the result should be positive or negative
        boolean positive = newNumerator * newDenominator > 0;
        if (!positive) {
            sb.append("-");
        }
        newNumerator = Math.abs(newNumerator);
        newDenominator = Math.abs(newDenominator);

        // calcuate number before dot
        long beforeDot = newNumerator / newDenominator;
        sb.append(beforeDot);

        // calcuate number after dot
        long currentNumerator = newNumerator % newDenominator;
        if (currentNumerator != 0) {
            sb.append(".");
        }

        // a map to record numerator that has been calcualted before to check start of possible loops
        Map<Long, Integer> numeratorCalculated = new HashMap<>();
        int afterDotPosition = sb.length();
        while (currentNumerator != 0) {
            if (numeratorCalculated.containsKey(currentNumerator)) {
                int insertPosition = numeratorCalculated.get(currentNumerator);
                sb.insert(insertPosition, "(");
                sb.append(")");
                break;
            } else {
                numeratorCalculated.put(currentNumerator, afterDotPosition);
            }

            currentNumerator *= 10;
            long currentBit = currentNumerator / newDenominator;
            sb.append(currentBit);
            afterDotPosition++;
            if (currentBit != 0) {
                currentNumerator = currentNumerator % newDenominator;
            }
        }

        return sb.toString();
    }
}