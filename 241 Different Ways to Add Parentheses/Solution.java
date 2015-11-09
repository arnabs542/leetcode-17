/*
Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.


Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.

Subscribe to see which companies asked this question
*/

//Reference: http://blog.welkinlan.com/2015/09/11/different-ways-to-add-parentheses-leetcode-java/
//Use divide & conquer method to solve this problem (Recursion!!!)
//Use hashTable to speed up the recursion!!!

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        HashMap<String, List<Integer>> hashMap = new HashMap<String, List<Integer>>();
        setUpMap(input, hashMap);
        return hashMap.get(input);
    }

    private void setUpMap (String s, HashMap<String, List<Integer>> map) {
    	List<Integer> resultList = new ArrayList<Integer>();
    	int length = s.length();
    	for (int i = 0; i < length; i ++) {
    		char c = s.charAt(i);
    		if (c != '+' && c != '-' && c != '*') {
                continue;
            }

    		String leftS = s.substring(0, i);
            String rightS = s.substring(i + 1, s.length());

            if (!map.containsKey(leftS)) {
            	setUpMap(leftS, map);
            }
            List<Integer> leftList = map.get(leftS); 

            if (!map.containsKey(rightS)) {
            	setUpMap(rightS, map);
            }
            List<Integer> rightList = map.get(rightS); 

    		if (c == '+') {
    			for (int l: leftList) {
    				for (int r: rightList) {
    					int result = l + r;
    					resultList.add(result);
    				}
    			}
    			map.put(s, resultList);
    		}
    		if (c == '-') {
    			for (int l: leftList) {
    				for (int r: rightList) {
    					int result = l - r;
    					resultList.add(result);
    				}
    			}
    			map.put(s, resultList);
    		}
    		if (c == '*') {
    			for (int l: leftList) {
    				for (int r: rightList) {
    					int result = l * r;
    					resultList.add(result);
    				}
    			}
    			map.put(s, resultList);
    		}
    	}
    	if (!map.containsKey(s)) {
    		resultList.add(Integer.parseInt(s));
    		map.put(s, resultList);
    	}
    }
}