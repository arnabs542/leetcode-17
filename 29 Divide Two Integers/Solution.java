class Solution {
    // we cannot use multiply, but we can use bit operation, which is also faster
    // bit operation is equal to multiply
    // reference: http://bangbingsyb.blogspot.com/2014/11/divide-two-integers-divide-two-integers.html
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE; //overflow problem

        boolean isNeg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        long dividendAbs = Math.abs((long)dividend); // need to use long, since abs(Integer.MIN_VALUE) will cause over flow
        long divisorAbs = Math.abs((long)divisor); // need to use long, since abs(Integer.MIN_VALUE) will cause over flow

        // quick check
        if (divisorAbs == 1) return (int)(isNeg ? (0 - dividendAbs) : dividendAbs);

        // use bit shift operation to roughly determine the range of result
        int bitPos = 0;
        while((divisorAbs << (bitPos + 1)) <= dividendAbs) {
            bitPos++;
        }

        // determine result for each bit position
        int result = 0;
        while (dividendAbs >= divisorAbs) {
            if (dividendAbs >= (divisorAbs << bitPos)) {
                result += (1 << bitPos);
                dividendAbs -= (divisorAbs << bitPos);
            }
            bitPos--;
        }
        return isNeg ? (0 - result) : result;
    }

    public int divide_timeout(int dividend, int divisor) {
        int quotient = 0;
        while (isDividable(dividend, divisor)) {
            if ((dividend >= 0 && divisor >= 0) || (dividend < 0 && divisor < 0)) {
                dividend -= divisor;
                if (quotient == Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                quotient++;
            } else {
                dividend += divisor;
                quotient--;
            }
        }
        return quotient;
    }

    private boolean isDividable(int dividend, int divisor) {
        if (dividend >= 0 && divisor >= 0) {
            return (dividend - divisor) >= 0;
        } else if (dividend < 0 && divisor < 0) {
            return (dividend - divisor) <= 0;
        } else if (dividend >= 0 && divisor < 0) {
            return (dividend + divisor) >= 0;
        } else {
            // dividend < 0 && divisor >= 0
            return (dividend + divisor) <= 0;
        }
    }
}