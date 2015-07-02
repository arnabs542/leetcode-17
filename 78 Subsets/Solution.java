/*
Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

public class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
		return subsetsInorder(nums);
	}

	//Use recursion method
    public List<List<Integer>> subsetsInorder(int[] nums) {
        int len = nums.length;

        if (len > 1) {
	        int[] subNums = new int[len - 1];

	        for (int i = 0; i < len - 1; i ++) {
	        	subNums[i] = nums[i];
	        }

	        List<List<Integer>> tempResult = subsets(subNums);
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        for (List<Integer> unitResult: tempResult) {
	        	List<Integer> newUnitResult = new ArrayList<Integer>();
	        	newUnitResult.addAll(unitResult);
	        	newUnitResult.add(nums[len - 1]);
	        	result.add(newUnitResult);
	        }
	        result.addAll(tempResult);

	        return result;
	    }
	    else {
	    	List<List<Integer>> result = new ArrayList<List<Integer>>();
	    	List<Integer> newUnitResult = new ArrayList<Integer>();
	    	result.add(newUnitResult);

	    	if (len == 1) {
	    		newUnitResult = new ArrayList<Integer>();
	    		newUnitResult.add(nums[0]);
	    		result.add(newUnitResult);
	    	}

	    	return result;
	    }
    }
}