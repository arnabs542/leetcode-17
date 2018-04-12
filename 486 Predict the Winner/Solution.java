// the reason why this solution does not work comparing to
// the solution provided in the blog is that this solution
// only consider the optimized solution for the first picker
// but did not consider or not fully consider the optimized
// solution for the seconder picker

// the key to that is to use the same optimization algoirthm
// for both pickers, but use the difference of the both
// optimized solution as recursion formula, that is the most
// important key point to the solution!!!

public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return helper(nums, 0, nums.length-1) >= 0;
    }

    private int helper(int[] nums, int start, int end) {
        if(start == end) {
            return nums[start];
        } else {
            return Math.max(nums[start] - helper(nums, start + 1,end), nums[end] - helper(nums, start,end - 1));
        }
    }
}

class Solution_DoesNotWork {
    public boolean PredictTheWinner(int[] nums) {
        List<Integer> numsList = new ArrayList<>();
        int sum = 0;
        int len = nums.length;
        for (int num: nums) {
            sum += num;
            numsList.add(num);
        }

        int firstPickMax = this.getMaxNum(numsList, 0, len - 1);
        int secondPickMax = sum - firstPickMax;
        return firstPickMax >= secondPickMax;
    }

    private int getMaxNum(List<Integer> numsList, int start, int end) {
        int len = end - start + 1;

        if (len <= 0) {
            return 0;
        } else if (len == 1) {
            return numsList.get(start);
        } else if (len == 2) {
            return Math.max(numsList.get(start), numsList.get(end));
        } else {
            if (numsList.get(start) >= numsList.get(end)) {
                // here we assume the second user is always willing to pick the bigger one
                if (numsList.get(start + 1) >= numsList.get(end)) {
                    return numsList.get(start) + getMaxNum(numsList, start + 2, end);
                } else {
                    return numsList.get(start) + getMaxNum(numsList, start + 1, end - 1);
                }
            } else {
                // here we assume the second user is always willing to pick the bigger one
                if (numsList.get(start) >= numsList.get(end - 1)) {
                    return numsList.get(end) + getMaxNum(numsList, start + 1, end - 1);
                } else {
                    return numsList.get(end) + getMaxNum(numsList, start, end - 2);
                }
            }
        }
    }
}