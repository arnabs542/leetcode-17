/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
class Solution {
    private Map<Integer, List<Integer>> map;

    public Solution(int[] nums) {
        this.map = genMap(nums);
    }

    public int pick(int target) {
        List<Integer> list = this.map.get(target);
        if (list.size() == 1) {
            return list.get(0);
        } else {
            return getRandomMember(list);
        }
    }

    private Map<Integer, List<Integer>> genMap(int[] nums) {
        int len = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        for (int i = 0; i < len; i++) {
            int num = nums[i];
            List<Integer> list;
            if (map.get(num) == null) {
                list = new ArrayList<Integer>();
                map.put(num, list);
            } else {
                list = map.get(num);
            }
            list.add(i);
        }

        return map;
    }

    private int getRandomMember(List<Integer> list) {
        Random randomizer = new Random();
        return list.get(randomizer.nextInt(list.size()));
    }
}
