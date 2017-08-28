// for better solution, please refer to http://blog.csdn.net/cloudox_/article/details/62881181
// it uses stack

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int MAX = -1;
        for (int cur = 0; cur < len; cur ++) {
            int next = (cur + 1) % len;
            boolean findNext = false;
            while (next != cur && !findNext) {
                if (nums[next] > nums[cur]) {
                    result[cur] = nums[next];
                    findNext = true;
                }
                next = (next + 1) % len;
            }
            if (!findNext) {
                result[cur] = MAX;
            }
        }
        return result;
    }
}
