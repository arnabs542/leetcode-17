/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
*/

//This problems has better solution as: http://fisherlei.blogspot.ca/2012/12/leetcode-merge-sorted-array.html
//This solution has Complexity of O(m + n)

public class Solution {
    //While this solution has complexity of O(mn)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer1 = 0;
        int pointer2 = 0;

        while (pointer1 < m && pointer2 < n) {
        	if (nums1[pointer1 + pointer2] <= nums2[pointer2]) {
        		pointer1 ++;
        	}
        	else {
        		for (int i = (m + pointer2 - 1); i >= (pointer1 + pointer2); i --) {
        			nums1[i + 1] = nums1[i];
        		}
        		nums1[pointer1 + pointer2] = nums2[pointer2];
        		pointer2 ++;
        	}
        } 

        if (pointer2 < n) {
        	for (int i = pointer2; i < n; i ++) {
        		nums1[i + pointer1] = nums2[i];
        	}
        }
    }
}