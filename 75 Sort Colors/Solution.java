/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
*/

public class Solution {
    public void sortColors (int[] nums) {
        // quickSort(nums, 0, nums.length - 1);
        // mergeSort(nums, 0, nums.length - 1);
        // countSort(nums);
        onePassSort(nums);
    }

    private void quickSort (int[] nums, int low, int high) {
    	if (low < high) {
    		int p = partition(nums, low, high);
    		quickSort(nums, low, p - 1);
    		quickSort(nums, p + 1, high);
    	}
    }

    private int partition (int[] nums, int low, int high) {
    	int left = low;
    	int right = high;
    	int pivot = left;

    	while (left < right) {
    		while (left < right && nums[pivot] <= nums[right]) {
    			right --;
    		}

    		if (left < right) {
    			swap(nums, pivot, right);
    			pivot = right;
    		} else {
    			break;
    		}

    		while (left < right && nums[pivot] >= nums[left]) {
    			left ++;
    		}

    		if (left < right) {
    			swap(nums, pivot, left);
    			pivot = left;
    		} else {
    			break;
    		}
    	}

    	return pivot;
    }

    private void swap (int[] nums, int i, int j) {
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }

    private void mergeSort (int[] nums, int start, int end) {
    	if (start < end) {
    		int mid = (start + end) / 2;

    		mergeSort(nums, start, mid);
    		int[] left = new int[mid - start + 1];
    		for (int i = 0; i < (mid - start + 1); i ++) {
    			left[i] = nums[start + i];
    		}
    		
			mergeSort(nums, mid + 1, end);
    		int[] right = new int[end - mid];
    		for (int i = 0; i < (end - mid); i ++) {
    			right[i] = nums[mid + 1 +i];
    		}

    		int leftIndex = 0;
    		int rightIndex = 0;

    		for (int i = start; i <= end; i ++) {
    			if (leftIndex < left.length && rightIndex < right.length && left[leftIndex] <= right[rightIndex]) {
    				nums[i] = left[leftIndex];
    				leftIndex ++;
    			} else if (leftIndex < left.length && rightIndex < right.length && left[leftIndex] > right[rightIndex]){
    				nums[i] = right[rightIndex];
    				rightIndex ++;
    			} else if (leftIndex >= left.length) {
    				nums[i] = right[rightIndex];
    				rightIndex ++;
    			} else if (rightIndex >= right.length) {
    				nums[i] = left[leftIndex];
    				leftIndex ++;
    			}
    		}
    	} 
    }

    private void countSort (int[] nums) {
    	int red = 0;
    	int white = 0;
    	int blue = 0;

    	for (int num: nums) {
    		switch (num) {
    			case(0):
    				red ++;
    				break;
    			case(1):
    				white ++;
    				break;
    			case(2):
    				blue ++;
    				break;
    		}
    	}

    	int index = 0;
    	while (red > 0) {
    		nums[index] = 0;
    		index ++;
    		red --;
    	}

    	while (white > 0) {
    		nums[index] = 1;
    		index ++;
    		white --;
    	}

    	while (blue > 0) {
    		nums[index] = 2;
    		index ++;
    		blue --;
    	}
    }

   private void onePassSort(int[] nums) {
    	int red = -1;
    	int white = -1;
    	int blue = -1;

    	for (int i = 0; i < nums.length; i ++) {
    		if (nums[i] == 0) {
    			red ++;
				swap(nums, i, red);			
				white ++;
				if (white > red) swap(nums, i, white);
				blue ++;
			}
			else if (nums[i] == 1) {
				white ++;
				swap(nums, i, white);
				blue ++;
			}
    		else if (nums[i] == 2) {
				blue ++;
    		}
    	}
    }

}