class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int len = A.length;
        if (len >= 3) {
            List<Integer> lenOfArithmeticSlices = new ArrayList<>();
            int prevCursor = 0;
            int curCursor = 1;
            int curDiff = 0;
            int curArithmeticsLen = 2;

            while (curCursor < len) {
                int tempDiff = A[curCursor] - A[prevCursor];
                if (tempDiff == curDiff) {
                    curArithmeticsLen++;
                    if (curCursor == (len - 1)) {
                        if (curArithmeticsLen > len) curArithmeticsLen = len;
                        lenOfArithmeticSlices.add(curArithmeticsLen);
                    }
                } else {
                    if (curArithmeticsLen >= 3) {
                        lenOfArithmeticSlices.add(curArithmeticsLen);
                    }
                    curArithmeticsLen = 2;
                }

                curDiff = tempDiff;
                curCursor++;
                prevCursor++;
            }

            int result = 0;
            for (int arithmeticSlicesLen: lenOfArithmeticSlices) {
                result += addUp(arithmeticSlicesLen - 2);
            }
            return result;
        } else {
            return 0;
        }
    }

    public int addUp(int n) {
        return (1 + n) * n / 2;
    }
}
