class Solution {
    private String getRange(int start, int end) {
        if (start != end) {
            return start + "->" + end;
        } else {
            return Integer.toString(start);
        }
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        // handle special cases
        if (nums.length == 0) return result;

        // two pointers to record start of current range
        // and the previous number visited
        int start = nums[0];
        int prev = start - 1;

        // loop through the array
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            // current range ends, starts a new range
            if (num != (prev + 1)) {
                result.add(getRange(start, prev));
                start = num;
            }

            // handle the case for the last number
            if (i == (nums.length - 1)) {
                if (num == (prev + 1)) {
                    result.add(getRange(start, num));
                } else {
                    result.add(getRange(num, num));
                }
            }

            prev = num;
        }

        return result;
    }
}