/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

public class Solution {
/*
The algorithm is like this for n = 5, k = 3:
1,2,3
1,2,4
1,2,5
1,3,4
1,3,5
1,4,5
2,3,4
2,3,5
2,4,5
3,4,5
Thus it is recursively defined. We'd better use recursion method.
*/
    public List<List<Integer>> combine (int n, int k) {
      List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<Integer> subResult = new ArrayList<Integer>();

		  combineRec(result, subResult, 1, n, 1, k);

      return result;
    }

    //Use recursion to solve the problem
    //result: the overall result
    //subResult: the result that already had (curLen - 1) elements, we need to add the (curLen)th element here
    //startNum: the start number that we need to add to the current position
    //curLen: the position that we start adding the element
    private void combineRec (List<List<Integer>> result, List<Integer> subResult, int startNum, int n, int curLen, int k) {
    	if ((n - startNum + 1) > (k - curLen) && startNum <= n && curLen <= k) {
    		for (int i = startNum; i <= (n - k + curLen); i ++) {
    			List<Integer> newSubResult = new ArrayList<Integer>();
    			newSubResult.addAll(subResult);
    			newSubResult.add(i);

    			if (curLen == k) {
    				result.add(newSubResult);
    			}

    			combineRec(result, newSubResult, i + 1, n, curLen + 1, k);
    		}
    	}
    }
}
