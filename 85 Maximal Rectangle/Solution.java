/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
*/

public class Solution {
	//DP
	//Reference: http://www.acmerblog.com/leetcode-solution-maximal-rectangle-6219.html
	//Reference: http://siddontang.gitbooks.io/leetcode-solution/content/array/maximal_rectangle.html
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int ans = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int heights[] = new int[matrix[0].length];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == '1')
                    heights[j] ++;
                else
                    heights[j] = 0;
            }
            int tmp = largestRectangleArea(heights);
            if(ans < tmp) ans = tmp;
        }

        return ans;
    }
    
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();
		int i=0;
		int ans = 0;
		while(i < heights.length){
			if(stack.isEmpty() || heights[i] > heights[stack.peek()] ){
				stack.push(i++);
			}else{
				int start = stack.pop();
				int width = stack.isEmpty() ? i : i-stack.peek()-1 ;
				ans = Math.max(ans, heights[start] * width);
			}
		}
		
		while(!stack.isEmpty()){
			int start = stack.pop();
			int width = stack.isEmpty() ? heights.length : heights.length-stack.peek()-1 ;
			ans = Math.max(ans, heights[start] * width);
		}
		return ans;
    }

	//use DP, only pass 61/65 test cases
	public int maximalRectangle_Wrong(char[][] matrix) {
	    int rowNum = matrix.length;
	    int colNum = 0;
	    if (rowNum != 0) {
	    	colNum = matrix[0].length;
	    }
	    
	    if (rowNum == 0 || colNum == 0) {
	    	return 0;
	    }

	    int maxArea = 0;

	    Rectangle[][] maxRec = new Rectangle[rowNum][colNum];
	    
	    maxRec[0][0] = new Rectangle();
	    if (matrix[0][0] == '1') {
	    	maxRec[0][0].setHeight(1);
	    	maxRec[0][0].setWidth(1);
	    	if (maxRec[0][0].getArea() > maxArea) {
				maxArea = maxRec[0][0].getArea();
			}
	    }

	    for (int i = 1; i < rowNum; i ++) {
	    	maxRec[i][0] = new Rectangle();
	    	if (matrix[i][0] == '1') {
	    		maxRec[i][0].setHeight(maxRec[i - 1][0].getHeight() + 1);
	    		maxRec[i][0].setWidth(1);
	    		if (maxRec[i][0].getArea() > maxArea) {
					maxArea = maxRec[i][0].getArea();
				}
	    	}
	    }
	    
	    for (int j = 1; j < colNum; j ++) {
	    	maxRec[0][j] = new Rectangle();
	    	if (matrix[0][j] == '1') {
	    		maxRec[0][j].setWidth(maxRec[0][j - 1].getWidth() + 1);
	    		maxRec[0][j].setHeight(1);
	    	}
	    	if (maxRec[0][j].getArea() > maxArea) {
				maxArea = maxRec[0][j].getArea();
			}
	    }
	    
	    for (int i = 1; i < rowNum; i ++) {
	    	for (int j = 1; j < colNum; j ++) {
	    		maxRec[i][j] = new Rectangle();
	    		
	    		if (matrix[i][j] == '1') {
	    			Rectangle maxRecTemp1 = new Rectangle();
	    			if (matrix[i][j - 1] == '1') {
	        			maxRecTemp1.setWidth(maxRec[i][j - 1].getWidth() + 1);
	        			int heightTemp = Math.min(maxRec[i][j - 1].getHeight(), maxRec[i - 1][j].getHeight() + 1);
	        			maxRecTemp1.setHeight(heightTemp);
	    			}

	    			Rectangle maxRecTemp2 = new Rectangle();
	    			if (matrix[i - 1][j] == '1') {
	        			maxRecTemp2.setHeight(maxRec[i - 1][j].getHeight() + 1);
	        			int widthTemp = Math.min(maxRec[i - 1][j].getWidth(), maxRec[i][j - 1].getWidth() + 1);
	        			maxRecTemp2.setWidth(widthTemp);
	    			}

	    			maxRec[i][j] = maxRecTemp1.getArea() >= maxRecTemp2.getArea() ? maxRecTemp1: maxRecTemp2;
	    			
	    			if (matrix[i][j - 1] == '0' && matrix[i - 1][j] == '0') {
	    				maxRec[i][j].setHeight(1);
	    				maxRec[i][j].setWidth(1);
	    			}
	    			
	    			if (maxRec[i][j].getArea() > maxArea) {
	    				maxArea = maxRec[i][j].getArea();
	    			}
	    		}
	    	}
	    }
	    
	    for (int i = 0; i < rowNum; i ++) {
	    	for (int j = 0; j < colNum; j ++) {
	    		System.out.print(maxRec[i][j].getArea() + " ");
	    	}
	    	System.out.println();
	    }

	    return maxArea;
	}

	private class Rectangle {
		int width;
		int height;

		public Rectangle () {
			this.width = 0;
			this.height = 0;
		}

		void setWidth (int width) {
			this.width = width;
		}

		void setHeight (int height) {
			this.height = height;
		}

		int getArea () {
			return width * height;
		}

		int getWidth () {
			return width;
		}

		int getHeight () {
			return height;
		}
	}
}