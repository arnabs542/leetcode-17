/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
*/

public class Solution {
	//use two pointers scan method
	public int trap(int[] height) {
		int result = 0;
		int len = height.length;

		if (len <= 2) return 0;

		int left = 0;
		int right = len - 1;

		while (left < right) {
			int curElevation = Math.min(height[left], height[right]);
			if (height[left] == curElevation) {
				left ++;
				while (left < right && height[left] <= curElevation) {
					result += (curElevation - height[left]);
					left ++;
				}
			}
			else {
				right --;
				while (left < right && height[right] <= curElevation) {
					result += (curElevation - height[right]);
					right --;
				}
			}
		}

		return result;
	}

	//This is the wrong answer that I use it first.
    public int trap_Wrong(int[] height) {
    	//the final result
    	int result = 0;

    	//the length of the array
        int len = height.length;

        //in a area of water, the left highest point
        int leftHeight = 0;;
        //in a area of water, the right highest point
        int rightHeight;

        //positon pointer to traverse the whole array
        int p = 0;

        //find the first leftHeight
        while (p < len) {
        	if (height[p] != 0) {
        		leftHeight = p;
        		p ++;
        		break;
        	}
        	p ++;
        }

        //find the next rightHeight
        while (p < len) {
        	if ((p < (len - 1) && height[p] >= height[p - 1] && height[p] >= height[p + 1]) ||
        		(p == (len - 1) && height[p] > height[p - 1])) {
        			rightHeight = p;
        			int resultTemp = calcWater(height, leftHeight, rightHeight);
        			result += resultTemp;
        			leftHeight = rightHeight;
        	}

        	p ++;
        }

    	return result;
    }

	//calculate the water volume between the two leftHeight and rightHeight pointer
    private int calcWater (int[] height, int leftHeight, int rightHeight) {
    	int result = 0;

    	if (leftHeight < rightHeight) {
    		int lowestH = Math.min(height[leftHeight], height[rightHeight]);
    		result = lowestH * (rightHeight - leftHeight - 1);

    		for (int i = leftHeight + 1; i < rightHeight; i ++) {
    			if (height[i] < lowestH) {
    				result -= height[i];
    			}
    			else {
    				result -= lowestH;
    			}
    		}
    	}

    	return result;
    }
}