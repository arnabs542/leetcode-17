/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/

public class Solution {
	//Reference: http://www.programcreek.com/2013/01/leetcode-longest-consecutive-sequence-java/
    public int longestConsecutive(int[] nums) {
    	int result = 0;

    	Set<Integer> set = new HashSet<Integer>();

        for (int num: nums) {
        	set.add(num);
        }

        for (int num: nums) {
        	int cur = num;
        	int left = num - 1;
        	int right = num + 1;

        	int len = 1;
        	set.remove(cur);

        	while (set.contains(right)) {
        		set.remove(right);
        		len ++;
        		right ++;
        	}

        	while (set.contains(left)) {
        		set.remove(left);
        		len ++;
        		left --;
        	}

        	if (len > result) {
        		result = len;
        	}
        }

        return result;
    }
}