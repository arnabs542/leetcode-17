class Solution {
    // reference: http://bookshadow.com/weblog/2016/09/11/leetcode-integer-replacement/
    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }

        int count = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n = n >>> 1;
            } else {
                if (((n >>> 1) & 1) == 0 || n == 3) {
                    n--;
                } else {
                    n++;
                }
            }
            count++;
        }
        return count;
    }

    public int _integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        if (n % 2 == 0) {
            return integerReplacement(n / 2) + 1;
        } else {
            return Math.min(integerReplacement(n + 1), integerReplacement(n - 1)) + 1;
        }
    }
}
