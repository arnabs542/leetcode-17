/*
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

//Solution: http://fisherlei.blogspot.ca/2013/11/leetcode-single-number-ii-solution.html

public class Solution {
	public int singleNumber(int[] nums) {
		int[] bitCounter = new int[32];
		int result = 0;

		for (int num : nums) {
			for (int i = 0; i < 32; i ++) {
				if ((num & (1 << i)) == (1 << i)) {
					bitCounter[i] ++;
				}
			}
		}

		for (int i = 0; i < 32; i ++) {
			bitCounter[i] = bitCounter[i] % 3;
			result = result | (bitCounter[i] << i);
		}

		return result;
	}

    public int singleNumber_WithExtraSpace(int[] nums) {
        Map<Integer, Integer> numberCounterMap = new HashMap<Integer, Integer>();

        for (int num : nums) {
        	if (numberCounterMap.containsKey(num)) {
        		int counter = numberCounterMap.get(num);
        		counter ++;
        		numberCounterMap.put(num, counter);
        	}
        	else {
        		int counter = 1;
        		numberCounterMap.put(num, counter);
        	}
        }

        for (int num : nums) {
        	if (numberCounterMap.get(num) == 1) return num;
        }

        return 0;
    }
}