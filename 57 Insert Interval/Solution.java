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
    // given that intervals is sorted by start time, we can consider Greedy Algorithm for this problem
    // we need to find the first Interval that includes new start time and the last interval includes new end time and merge the intervals between them
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        List<Interval> intervalsToMerge = new ArrayList<>();
        intervalsToMerge.add(newInterval);

        if(intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }

        Interval curInterval = null;
        boolean newIntervalLocated = false; // mark if newInterval has been inserted
        boolean duringMerge = false; // mark if we need to merge intervals

        // there are only 3 cases we need to consider when comparing
        // 1. new interval is in LHS of the current interval
        // 2. new interval is in RHS of the current interval
        // 3. new interval has intersection with current interval
        for (int i = 0; i < intervals.size(); i++) {
            curInterval = intervals.get(i);

            if (newIntervalLocated) {
                result.add(curInterval);
            } else {
                if (isLeftSideInterval(newInterval, curInterval)) {
                    // Left Hand Side case
                    if (duringMerge) {
                        duringMerge = false;
                        result.add(mergeIntervals(intervalsToMerge));
                    } else {
                        result.add(newInterval);
                    }
                    result.add(curInterval);
                    newIntervalLocated = true;
                } else if (isRightSideInterval(newInterval, curInterval)) {
                    // Right Hand Side case
                    if ((intervals.size() - 1) == i) {
                        result.add(curInterval);
                        result.add(newInterval);
                        newIntervalLocated = true;
                    } else {
                        result.add(curInterval);
                    }
                } else {
                    // have intersection with the interval
                    duringMerge = true;
                    intervalsToMerge.add(curInterval);
                }
            }
        }

        if (duringMerge) {
            result.add(mergeIntervals(intervalsToMerge));
            duringMerge = false;
        }

        return result;
    }

    private Interval mergeIntervals(List<Interval> intervalsToMerge) {
        if (intervalsToMerge.size() == 0) return new Interval();

        int minStart = Integer.MAX_VALUE;
        int maxEnd = Integer.MIN_VALUE;

        for (Interval intervalTemp: intervalsToMerge) {
            if (intervalTemp.start < minStart) {
                minStart = intervalTemp.start;
            }
            if (intervalTemp.end > maxEnd) {
                maxEnd = intervalTemp.end;
            }
        }

        return new Interval(minStart, maxEnd);
    }

    private boolean isLeftSideInterval(Interval newInterval, Interval curInterval) {
        return newInterval.end < curInterval.start;
    }

    private boolean isRightSideInterval(Interval newInterval, Interval curInterval) {
        return newInterval.start > curInterval.end;
    }
}