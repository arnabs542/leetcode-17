// Another simpler code: https://leetcode.com/problems/meeting-rooms-ii/discuss/887167/EASY-JAVA-SOLUTION-using-Priority-Queue
class Solution {
    class Meeting {
        public int start;
        public int end;
        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int minMeetingRooms(int[][] intervals) {
        // special case handling
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) return 0;

        // init a queue for meetings
        Queue<Meeting> meetingQueue = new PriorityQueue<>((a, b) -> a.start - b.start);
        for (int[] meeting: intervals) {
            Meeting tempMeeting = new Meeting(meeting[0], meeting[1]);
            meetingQueue.add(tempMeeting);
        }

        // check the maximum number of meetings that needs to happen at the same time
        int meetingRoomsNeeded = 0;
        int minMeetingRooms = 0;
        Queue<Integer> endMeetingQueue = new PriorityQueue<>();
        while (!meetingQueue.isEmpty()) {
            Meeting newMeeting = meetingQueue.poll();
            endMeetingQueue.add(newMeeting.end);
            meetingRoomsNeeded++;
            while (!endMeetingQueue.isEmpty() && newMeeting.start >= endMeetingQueue.peek()) {
                endMeetingQueue.poll();
                meetingRoomsNeeded--;
            }
            minMeetingRooms = Math.max(minMeetingRooms, meetingRoomsNeeded);
        }

        return minMeetingRooms;
    }
}