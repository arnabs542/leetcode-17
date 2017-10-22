class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<Integer>();
        Set<Integer> nums2Set = new HashSet<Integer>();
        for (int temp: nums1) {
            nums1Set.add(temp);
        }
        for (int temp: nums2) {
            if (nums1Set.contains(temp)) {
                nums2Set.add(temp);
            }
        }
        int[] result = new int[nums2Set.size()];
        int i = 0;
        for (int temp: nums2Set) {
            result[i] = temp;
            i++;
        }
        return result;
    }
}
