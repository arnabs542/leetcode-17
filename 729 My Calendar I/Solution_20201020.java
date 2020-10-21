class MyCalendar {
    class Meeting {
        public int start;
        public int end;
        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // the list of meetings will be sorted by meeting start dates
    private List<Meeting> meetings;

    public MyCalendar() {
        this.meetings = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        Meeting meeting = new Meeting(start, end);
        int meetingIndexToInsert = getMeetingIndexToInsert(meeting);
        if (meetingIndexToInsert < 0) {
            return false;
        } else {
            // check conflict with the meeting afterwards
            if (meetingIndexToInsert < this.meetings.size() &&
                end > this.meetings.get(meetingIndexToInsert).start) {
                return false;
            }
            // check conflict with the previous meeting
            if (meetingIndexToInsert - 1 >= 0 &&
                start < this.meetings.get(meetingIndexToInsert - 1).end) {
                return false;
            }
            // now we can insert the meeting
            this.meetings.add(meetingIndexToInsert, meeting);
            return true;
        }
    }

    // find the meeting index to insert a new meeting at
    // by finding the nearest meeting by start date
    // if do not find the meeting, return -1
    private int getMeetingIndexToInsert(Meeting m) {
        // special case handling
        if (this.meetings.size() == 0) return 0;

        // use Binary Search to find the index to insert
        int start = 0;
        int end = this.meetings.size() - 1;

        // check the most left and right case
        if (m.start < this.meetings.get(start).start) return 0;
        if (m.start > this.meetings.get(end).start) return end + 1;

        // Binary Search between start and end
        while (start < end) {
            int mid = (start + end) / 2;
            if (m.start == this.meetings.get(mid).start) {
                return -1;
            } else if (m.start < this.meetings.get(mid).start) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (m.start != this.meetings.get(start).start) {
            if (m.start > this.meetings.get(start).start) return start + 1;
            else return start;
        }

        return -1;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
