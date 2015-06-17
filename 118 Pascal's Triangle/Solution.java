/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

public class Solution {
    public List<List<Integer>> generate (int numRows) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();

    	if (numRows == 0) {
    		return result;
    	}

    	List<Integer> list = new ArrayList<Integer>();
    	list.add(1);
    	result.add(list);

    	for (int i = 1; i < numRows; i ++) {
    		list = genList(list);
    		result.add(list);
    	}
        
        return result;
    }

    private List<Integer> genList (List<Integer> nums) {
    	List<Integer> list = new ArrayList<Integer>();

    	list.add(1);
    	for (int i = 0; i < (nums.size() - 1); i ++) {
    		int temp = nums.get(i) + nums.get(i + 1);
    		list.add(temp);
    	}
    	list.add(1);

    	return list;
    }
}