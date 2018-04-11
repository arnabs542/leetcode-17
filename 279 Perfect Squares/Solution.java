class Solution {
    private int[] constructNumSquareArray(int n) {
        int len = n + 1;
        int[] numSquaresArray = new int[len];
        numSquaresArray[0] = 0;
        for (int i = 1; i <= n; i++) {
            int maxSqrt = (int) Math.sqrt(i);
            int minNumSquare = Integer.MAX_VALUE;
            for (int j = 1; j <= maxSqrt; j++) {
                int curSquare = (int) Math.pow(j, 2);
                int tempMinNumSquare = numSquaresArray[i - curSquare];
                if (tempMinNumSquare < minNumSquare) {
                    minNumSquare = tempMinNumSquare;
                }
            }
            numSquaresArray[i] = minNumSquare + 1;
        }
        return numSquaresArray;
    }

    public int numSquares(int n) {
        int[] results = this.constructNumSquareArray(n);
        return results[n];
    }
}