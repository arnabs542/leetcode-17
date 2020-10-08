class Solution {
    public int maxChunksToSorted(int[] arr) {
        // special case handling
        if (arr == null || arr.length == 0) return 0;

        // use recursion to get result
        return maxChunksToSorted(arr, 0, arr.length - 1).size();
    }

    class Range {
        public int min;
        public int max;
        public Range(int min, int max) {
            // TODO: throw exception when max < min
            this.min = min;
            this.max = max;
        }
    }

    public List<Range> maxChunksToSorted(int[] arr, int start, int end) {
        // TODO: throw exception when start > end
        List<Range> resultChunks = new ArrayList<>();

        if (start == end) {
            // base case
            Range chunk = new Range(arr[start], arr[end]);
            resultChunks.add(chunk);
        } else {
            // recursively get max chunks
            List<Range> subArrayChunks = maxChunksToSorted(arr, start, end - 1);

            int currentNumber = arr[end];
            boolean isMax = true;

            for (int i = 0; i < subArrayChunks.size(); i++) {
                Range tempRange = subArrayChunks.get(i);
                if (tempRange.max < currentNumber) {
                    // current number does not impact current chunk
                    resultChunks.add(tempRange);
                } else {
                    // need to merge all chunks after current chunk (including current chunk)
                    isMax = false;

                    // construct new range
                    int endRangeMin = Math.min(tempRange.min, currentNumber);
                    Range endRange = new Range(endRangeMin, subArrayChunks.get(subArrayChunks.size() - 1).max);

                    resultChunks.add(endRange);
                    break;
                }
            }

            // current number can be a separate chunk
            if (isMax) {
                Range chunk = new Range(currentNumber, currentNumber);
                resultChunks.add(chunk);
            }
        }

        return resultChunks;
    }
}