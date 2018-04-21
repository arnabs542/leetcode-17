class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
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