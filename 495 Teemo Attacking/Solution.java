class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int startTimePoint = 0;
        int endTimePoint = 0;
        int totalPoisonedTime = 0;

        for (int start: timeSeries) {
            if (start > endTimePoint) {
                // this is a new poisioned time period
                totalPoisonedTime += endTimePoint - startTimePoint;

                // reset poisioned time period
                startTimePoint = start;
                endTimePoint = startTimePoint + duration;
            } else {
                // the poisioned time is expanded
                endTimePoint = start + duration;
            }
        }

        // the last poisioned time
        totalPoisonedTime += endTimePoint - startTimePoint;

        return totalPoisonedTime;
    }
}
