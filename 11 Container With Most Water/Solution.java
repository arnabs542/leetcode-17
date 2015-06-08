/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
*/

//Reference: http://blog.csdn.net/wzy_1988/article/details/17248209
//Reference: http://fisherlei.blogspot.ca/2013/01/leetcode-container-with-most-water.html

//Summary: Initially, I am going to solve this by DP(Dynamic Programming), which is O(n^2). I got Time Limeited Error.
//We should use two-point scan here, which is more like a greedy algorithm to get the optimization solution in O(n).

public class Solution {
    public int maxArea(int[] height) {
    	int length = height.length;

    	if (length == 0) return 0;

    	int l = 0;
    	int lHeight = height[l];
    	int r = length - 1;
    	int rHeight = height[r];
    	int max = (r - l) * Math.min(height[l], height[r]);

    	while (l < r) {
    		if (height[l] <= height[r]) {
    			l ++;
    			if (height[l] > lHeight) {
    				lHeight = height[l];
    				int maxT = (r - l) * Math.min(height[l], height[r]);
    				max = (maxT > max) ? maxT: max;
    			}
    		}
    		else {
    			r --;
    			if (height[r] > rHeight) {
    				rHeight = height[r];
    				int maxT = (r - l) * Math.min(height[l], height[r]);
    				max = (maxT > max) ? maxT: max;
    			}
    		}
    	}

    	return max;
    }
}