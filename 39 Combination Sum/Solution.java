/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/

public class Solution {
	//Use recursion to solve this problem
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	//sort the input int array
        Arrays.sort(candidates);

		List<List<Integer>> result = new ArrayList<List<Integer>>();

        int len = candidates.length;

        //generate the solution recursively
        for (int i = 0; i < len; i ++) {
        	//only consider the elemet that is smaller than the target
        	if (candidates[i] <= target) {
        		int cur = candidates[i];
        		//the possible time that this element might occur in the result
        		int freq = target / cur;

        		//create a new int array that only contains the elements smaller than the current element
        		int[] newCandidates = new int[i];
        		for (int j = 0; j < i; j ++) {
        			newCandidates[j] = candidates[j];
        		}

        		//check all possible solution that includes the certain numbers of the current element
        		for (int j = 1; j <= freq; j ++) {
        			if ((j * cur) == target) {
        				List<Integer> list = new ArrayList<Integer>();
        				for (int k = 0; k < j; k ++) {
        					list.add(cur);
        				}
        				result.add(list);
        			}
        			else {
        				int tempTarget = target - j * cur;
        				//calculate the new target that is the original target minus the freq * currentElement
        				List<List<Integer>> tempLists = combinationSum(newCandidates, tempTarget);
        				for (List<Integer> tempList: tempLists) {
        					for (int k = 0; k < j; k ++) {
        						tempList.add(cur);
        					}
        				}

        				result.addAll(tempLists);
        			}
        		}
        	}
        }

        return result;
    }
}