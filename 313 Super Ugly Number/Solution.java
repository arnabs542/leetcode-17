class Solution {
    // ref: https://leetcode.com/problems/super-ugly-number/discuss/76291/Java-three-methods-23ms-36-ms-58ms(with-heap)-performance-explained
    // good explanation: https://leetcode.com/problems/super-ugly-number/discuss/277313/My-view-of-this-question-hope-it-can-help-you-understand!!!
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] superUglyNumbers = new int[n];
        int primesNumber = primes.length;
        int[] superUglyNumbersIdxForPrime = new int[primesNumber];

        superUglyNumbers[0] = 1;

        for (int i = 1; i < n; i++) {
            superUglyNumbers[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primesNumber; j++) {
                superUglyNumbers[i] = Math.min(superUglyNumbers[i], primes[j] * superUglyNumbers[superUglyNumbersIdxForPrime[j]]);
            }

            for (int j = 0; j < primesNumber; j++) {
                if (primes[j] * superUglyNumbers[superUglyNumbersIdxForPrime[j]] <= superUglyNumbers[i]) {
                    superUglyNumbersIdxForPrime[j]++;
                }
            }
        }

        return superUglyNumbers[n - 1];
    }
}