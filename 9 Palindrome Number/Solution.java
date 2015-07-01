/*
Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
*/

public class Solution {

    public boolean isPalindrome_1(int x) {
        int temp = x;

        int reverse = 0;

        while (temp != 0) {
        	int t = temp % 10;
        	temp /= 10;
        	reverse *= 10;
        	reverse += t;
        }

        if (Math.abs(x) == reverse) {
        	return true;
        }

        return false;
    }

    //Another solution: http://fisherlei.blogspot.ca/2012/12/leetcode-palindrome-number.html
    public boolean isPalindrome(int x) {
		if (x < 0) return false;
        int div = 1;

        while ((x / div) >= 10) {
        	div *= 10;
        }

        while (x > 0) {
        	int low = x % 10;
        	int high = x / div;
        	if (low != high) {
        		return false;
        	}
        	x -= low;
        	x -= high * div;
        	div /= 100;
        	x /= 10;
        }

        return true;
    }

}