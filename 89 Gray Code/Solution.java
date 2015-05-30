/*
he gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
*/

//Other's thoughts: http://fisherlei.blogspot.ca/2012/12/leetcode-gray-code.html

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        int temp = 0;
        result.add(temp);

        if (n == 0) return result;

        temp = 1;
        result.add(temp);

        for (int i = 0; i < (n - 1); i ++) {
        	int length = result.size();

        	for (int j = (length - 1); j >= 0; j --) {
        		temp = result.get(j);
        		temp += (1 << (i + 1));
        		result.add(temp);
        	}
        }

        return result;
    }
}