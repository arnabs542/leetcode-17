/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

//Solution: http://fisherlei.blogspot.ca/2012/12/leetcode-maximum-subarray.html

public class Solution {
	//Divide and Conquer
	public int maxSubArray(int[] nums) {
		int length = nums.length;
		int result;

		if (length > 0) {
			result = maxSubArrayDivideConquer(nums, 0, length - 1);
		}
		else {
			result = 0;
		}

		return result;
	}

	private int maxSubArrayDivideConquer(int[] nums, int head, int tail) {
		int result;
		int length = nums.length;

		if (head == tail) {
			result = nums[head];
		}
		else if ((tail - head) == 1) {
			int maxHead = maxSubArrayDivideConquer(nums, head, head);
			int maxTail = maxSubArrayDivideConquer(nums, tail, tail);
			result = max(maxHead, maxTail, (maxHead + maxTail));
		}
		//(tail - head) > 1
		else {
			int mid = (head + tail) / 2;
			int maxHead = maxSubArrayDivideConquer(nums, head, mid - 1);
			int maxTail = maxSubArrayDivideConquer(nums, mid + 1, tail);
			int maxMid = maxMid(nums, head, tail);

			result = max(maxHead, maxTail, maxMid);
		}

		return result;
	}

	private int maxMid (int[] nums, int head, int tail) {
		int mid = (head + tail) / 2;

		int leftMax = nums[mid];
		int leftSum[] = new int[mid - head + 1];
		leftSum[0] = nums[mid];
		int rightMax = nums[mid];
		int rightSum[] = new int[tail - mid + 1];
		rightSum[0] = nums[mid];

		for (int i = (mid - 1); i >= head; i --) {
			int position = mid - i;
			leftSum[position] = leftSum[position - 1] + nums[i];

			if (leftSum[position] > leftMax) {
				leftMax = leftSum[position];
			} 
		}

		for (int i = (mid + 1); i <= tail; i ++) {
			int position = i - mid;
			rightSum[position] = rightSum[position - 1] + nums[i];

			if (rightSum[position] > rightMax) {
				rightMax = rightSum[position];
			} 
		}

		return (leftMax + rightMax - nums[mid]);
	}

	private int max (int a, int b, int c) {
		return Math.max(Math.max(a, b), c);
	}

	//DP
	public int maxSubArray_DP(int[] nums) {
		int length = nums.length;
		int result;

		if (length > 0) {
			int[] max = new int[length];

			max[0] = nums[0];

			for (int i = 1; i < length; i ++) {
				if ((max[i - 1])  > 0) {
					max[i] = max[i - 1] + nums[i];
				}
				else {
					max[i] = nums[i];
				}
			}

			result = max[0];
			for (int i = 1; i < length; i ++) {
				if (result < max[i]) {
					result = max[i];
				}
			}
		}
		else {
			result = 0;
		}

		return result;
	}

    public int maxSubArray_Original(int[] nums) {
		int length = nums.length;
		int max;
		
		if (length > 0) {
	        max = nums[0];
	        int currentMax = nums[0];
	
	        int cursor = 1;
	        while (cursor < length) {
	        	if (nums[cursor] >= 0) {
	        		if (currentMax > 0) {
	        			currentMax += nums[cursor];
	        		}
	        		else {
	        			currentMax = nums[cursor];
	        		}

	        		if (currentMax >= max) {
	        			max = currentMax;
	        		}

	        		cursor ++;
	        	}
	        	else {
	        		if (max < 0) {
	        			if (nums[cursor] > max) {
	        				max = nums[cursor];
	        			}
	        			cursor ++;
	        		}
	        		else {
		        		int sumTemp = nums[cursor];
		        		cursor ++;
		        		
		        		while (cursor < length && nums[cursor] < 0) {
		        			sumTemp += nums[cursor];
		        			cursor ++;
		        		}
		
		        		if ((sumTemp + currentMax) < 0) {
		        			currentMax = 0;
		        		}
		        		else {
		        			currentMax += sumTemp;
		        		}
		        	}
	        	}
	        }
		}
		else {
			max = 0;
		}
		
		return max;
    }
}