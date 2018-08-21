import java.util.ArrayList;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        // deal with special cases
        int count = intervals.size();
        if (count <= 1) {
            return intervals;
        }

        // sort the array of Intervals, n * log(n)
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        // merge one after one
        List<Interval> mergeResult = new ArrayList<>();
        Interval prevInterval = intervals.get(0);
        Interval curInterval = null;
        for (int i = 1; i < count; i++) {
            curInterval = intervals.get(i);
            if (hasIntersection(prevInterval, curInterval)) {
                // merge two intervals
                curInterval = mergeIntervals(prevInterval, curInterval);
            } else {
                // add the previous interval
                mergeResult.add(prevInterval);
            }
            prevInterval = curInterval;
        }
        // add the last result
        mergeResult.add(curInterval);

        return mergeResult;
    }

    // assume intervalA.start <= intervalB.start as inputs
    private boolean hasIntersection(Interval intervalA, Interval intervalB) {
        return intervalA.end >= intervalB.start;
    }

    private Interval mergeIntervals(Interval intervalA, Interval intervalB) {
        int newStart = Math.min(intervalA.start, intervalB.start);
        int newEnd = Math.max(intervalA.end, intervalB.end);
        return new Interval(newStart, newEnd);
    }
}