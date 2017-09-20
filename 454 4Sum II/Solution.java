// reference: http://www.cnblogs.com/grandyang/p/6073317.html
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int sumCount = 0;

        Map<Integer, Integer> sumAB = this._getSumMap(A, B);
        Map<Integer, Integer> sumCD = this._getSumMap(C, D);

        for (int sum: sumAB.keySet()) {
            if (sumCD.get((-1) * sum) != null) {
                sumCount += sumAB.get(sum) * sumCD.get((-1) * sum);
            }
        }

        return sumCount;
    }

    private Map<Integer, Integer> _getSumMap(int[] A, int[] B) {
        Map<Integer, Integer> sumAB = new HashMap<Integer, Integer>();
        int lenA = A.length;
        int lenB = B.length;
        for (int i = 0; i < lenA; i++) {
            for (int j = 0; j < lenB; j++) {
                int curSum = A[i] + B[j];
                if (sumAB.get(curSum) == null) {
                    sumAB.put(curSum, 1);
                } else {
                    sumAB.put(curSum, sumAB.get(curSum) + 1);
                }
            }
        }
        return sumAB;
    }
}
