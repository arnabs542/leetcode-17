/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/

public class Solution {
	//use DP method to solve this problem
    public int minimumTotal(List<List<Integer>> triangle) {
        ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();

        int height = triangle.size();
        if (height == 0) return 0;

        //get the min path value for every element in the triangle
        for (int i = 0; i < height; i ++) {
        	//a list that stores the min path value for every element of the current row
        	List<Integer> listTemp = new ArrayList<Integer>();
        	List<Integer> triangleCurRow = triangle.get(i);

        	int len = triangleCurRow.size();
        	for (int j = 0; j < len; j ++) {
        		//current element
        		int curEle = triangleCurRow.get(j);

        		if (i > 0) {
        			if (j > 0) {
        				//the last element of the current row
        				if (j == i) {
        					int minPath = list.get(i - 1).get(j - 1) + curEle;
        					listTemp.add(minPath);
        				}
        				else {
        					int minPath = Math.min(list.get(i - 1).get(j), list.get(i - 1).get(j - 1)) + curEle;
        					listTemp.add(minPath);
        				}
        			}
        			//j == 0
        			else {
        				int minPath = list.get(i - 1).get(j) + curEle;
        				listTemp.add(minPath);
        			}
        		}
        		//i == 0
        		else {
        			listTemp.add(curEle);
        		}
        	}

        	list.add(listTemp);
        }

        int min = minElement(list.get(height - 1));
        return min;
    }

    //return the minium of the list
    private int minElement(List<Integer> list) {
    	int min = list.get(0);
    	for (int e: list) {
    		if (e < min) {
    			min = e;
    		}
    	}
    	return min;
    }
}