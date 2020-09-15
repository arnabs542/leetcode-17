class Solution {
    public int hIndex(int[] citations) {
        // Bucket sort
        // Ref: https://leetcode.com/problems/h-index/discuss/70768/Java-bucket-sort-O(n)-solution-with-detail-explanation
        int n = citations.length;

        // init buckets
        int[] buckets = new int[n+1];
        for(int c : citations) {
            if(c >= n) {
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }

        // find out the highest hIndex
        int count = 0;
        for(int i = n; i >= 0; i--) {
            count += buckets[i];
            if(count >= i) {
                return i;
            }
        }

        return 0;
    }

    public int hIndex_BinarySearch(int[] citations) {
        // special case handle
        int lens = citations.length;
        if (lens == 0) return 0;

        // sort the array
        Arrays.sort(citations);

        // find out the highest hIndex with Binary Search
        int searchEnd = lens - 1;
        int searchStart = 0;
        int searchCurrent = (searchStart + searchEnd) / 2;
        while (searchStart <= searchEnd) {
            int hIndex = searchCurrent + 1;
            if (citations[lens - hIndex] >= hIndex) {
                if (hIndex == lens || citations[lens - hIndex - 1] < (hIndex + 1)) {
                    return hIndex;
                }
                searchStart = searchCurrent + 1;
            } else {
                searchEnd = searchCurrent - 1;
            }
            searchCurrent = (searchStart + searchEnd) / 2;
        }

        return 0;
    }

    public int hIndex_BruteForce(int[] citations) {
        // special case handle
        int lens = citations.length;
        if (lens == 0) return 0;

        // sort the array
        Arrays.sort(citations);

        // find out the highest hIndex with Brute Force
        for (int i = lens; i > 0; i--) {
            if (citations[lens - i] >= i) {
                return i;
            }
        }

        return 0;
    }
}