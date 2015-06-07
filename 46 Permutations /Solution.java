/*
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/

//Reference: http://blog.csdn.net/tuantuanls/article/details/8717262
//There are 4 alternative solutions listed there

public class Solution {
	//use recursion method, implemented the 1st solution in the referce (Recursion!)
    public ArrayList<ArrayList<Integer>> permute(int[] nums) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	
    	if (nums.length == 1) {
    		ArrayList<Integer> t = new ArrayList<Integer>();
    		t.add(nums[0]);
    		result.add(t);
    	}
    	else if (nums.length > 1) {
	    	ArrayList<ArrayList<Integer>> temp;

	        for (int num: nums) {
	        	int[] newNums = rmEle(nums, num);
	        	temp = permute(newNums);
	        	for (ArrayList<Integer> t: temp) {
	        		t.add(num);
	        	}

	        	result.addAll(temp);
	        }
	    }

        return result;
    }

    private int[] rmEle(int[] nums, int e) {
    	int[] result = new int[nums.length - 1];
    	int t = 0;
    	Boolean findE = false;

    	for (int i = 0; i < (nums.length - 1); i ++) {
    		if (nums[t] == e && findE == false) {
    			findE = true;
    			t ++;
    		}
    		
    		result[i] = nums[t];
			t ++;
    	}

    	return result;
    }
}