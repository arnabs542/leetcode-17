class Solution {
    // solution I like
    // reference: https://www.jiuzhang.com/solution/median-of-two-sorted-arrays/
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 0) {
            return (findKthElement(nums1, nums2, len / 2) + findKthElement(nums1, nums2, len / 2 + 1)) / 2.0;
        } else {
            return findKthElement(nums1, nums2, len / 2 + 1);
        }
    }

    // k is not zero-based, it starts from 1
    public int findKthElement(int[] num1, int[] num2, int k) {
        if(num1.length == 0) {
            return num2[k - 1];
        }
        if(num2.length == 0) {
            return num1[k - 1];
        }

        int start = Math.min(num1[0], num2[0]);
        int end = Math.max(num1[num1.length - 1], num2[num2.length - 1]);

        // find first x that >= k numbers is smaller or equal to x
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (countSmallerOrEqual(num1, mid) + countSmallerOrEqual(num2, mid) < k) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (countSmallerOrEqual(num1, start) + countSmallerOrEqual(num2, start) >= k) {
            return start;
        } else {
            return end;
        }
    }

    private int countSmallerOrEqual(int[] arr, int number) {
        int start = 0, end = arr.length - 1;

        // find first index that arr[index] > number;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] <= number) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (arr[start] > number) {
            return start;
        }
        if (arr[end] > number) {
            return end;
        }
        return arr.length;
    }

    // my original solution
    public double findMedianSortedArrays_original(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int cursor1 = 0;
        int cursor2 = 0;
        int medianPosition = (len1 + len2) / 2 + 1;
        int count = 0;
        int curVal = 0;
        int prevVal = 0;

        while (cursor1 < len1 || cursor2 < len2) {
            if (cursor1 >= len1) {
                prevVal = curVal;
                curVal = nums2[cursor2];
                cursor2++;
            } else if (cursor2 >= len2) {
                prevVal = curVal;
                curVal = nums1[cursor1];
                cursor1++;
            } else {
                int num1 = nums1[cursor1];
                int num2 = nums2[cursor2];
                if (num1 > num2) {
                    prevVal = curVal;
                    curVal = nums2[cursor2];
                    cursor2++;
                } else {
                    prevVal = curVal;
                    curVal = nums1[cursor1];
                    cursor1++;
                }
            }
            count++;
            if (count == medianPosition) {
                if ((len1 + len2) % 2 == 0) {
                    return (double)((double)(curVal + prevVal) / 2);
                } else {
                    return (double)curVal;
                }
            }
        }

        return 0;
    }
}