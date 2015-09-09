/*
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime?

Hint:

A naive implementation of the above process is trivial. Could you come up with other methods?
What are all the possible results?
How do they occur, periodically or randomly?
You may find this Wikipedia article useful.
*/

public class Solution {
	//find the rule when calculating the numbers
	//this runs in O(1) time
	public int addDigits(int num) {
		if (num == 0) return 0;
		if (num % 9 != 0) {
			return num % 9;
		}
		else {
			return 9;
		}
	}

    public int addDigits_normal(int num) {
    	int sum = 0;
    	int temp = num;
        while (temp != 0) {
        	sum += temp % 10;
        	temp /= 10;
        }

        while (sum >= 10) {
        	sum = addDigits(sum);
        }

        return sum;
    }
}