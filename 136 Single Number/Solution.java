/*
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

//Solution: http://www.programcreek.com/2012/12/leetcode-solution-of-single-number-in-java/

public class Solution {
	public int singleNumber(int[] nums) {
	    int result = 0;

	    for (int temp : nums) {
	    	result = result ^ temp;
	    }
	    
	    return result;
	}

	public int singleNumber_Original(int[] nums) {
	    ArrayList<Integer> list = new ArrayList<Integer>();

	    for (int temp : nums) {
	    	if (list.contains(temp)) {
	    		Integer tempInteger = new Integer(temp);
	    		list.remove(tempInteger);
	    	}
	    	else {
	    		list.add(temp);
	    	}
	    }
	    
	    return list.get(0);
	}
}
