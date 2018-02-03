class MyCalendar {
    Map<Integer, Integer> startToEndMap;
    List<Integer> starts;

    public MyCalendar() {
        startToEndMap = new HashMap<>();
        starts = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        int len = starts.size();
        if (len == 0) {
            this.addEvent(start, end);
            return true;
        }

        int left = -1;
        int right = -1;
        for (int i = 0; i < len; i++) {
            if (starts.get(i) > start) {
                if (right == -1 || starts.get(i) < starts.get(right)) {
                    right = i;
                }
            }
            if (starts.get(i) <= start) {
                if (left == -1 || starts.get(i) > starts.get(left)) {
                    left = i;
                }
            }
        }

        if (left >= 0) {
            if (starts.get(left) == start) return false;
            if (starts.get(left) < start) {
                if (startToEndMap.get(starts.get(left)) <= start) {
                    if (right >= 0) {
                        if (starts.get(right) >= end) {
                            this.addEvent(start, end);
                            return true;
                        }
                    } else {
                        this.addEvent(start, end);
                        return true;
                    }
                }
            }
        } else {
            if (right >= 0) {
                if (starts.get(right) >= end) {
                    this.addEvent(start, end);
                    return true;
                }
            } else {
                this.addEvent(start, end);
                return true;
            }
        }

        return false;
    }

    public boolean book_TimeOutSolution(int start, int end) {
        int len = starts.size();
        if (len == 0) {
            this.addEvent(start, end);
            return true;
        }

        Collections.sort(starts);
        int pos = binarySearch(starts, start);
        if (starts.get(pos) == start) return false;
        if (starts.get(pos) > start) {
            if (end <= starts.get(pos)) {
                this.addEvent(start, end);
                return true;
            }
        }
        if (starts.get(pos) < start) {
            if (startToEndMap.get(starts.get(pos)) <= start) {
                if ((pos + 1) < len) {
                    if (starts.get(pos + 1) >= end) {
                        this.addEvent(start, end);
                        return true;
                    }
                } else {
                    this.addEvent(start, end);
                    return true;
                }
            }
        }
        return false;
    }

    private int binarySearch(List<Integer> starts, int start) {
        int len = starts.size();

        if (len == 0) return 0;

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (start < starts.get(mid)) {
                right = mid - 1;
            } else {
                left = mid;
            }

        }
        return left;
    }

    private void addEvent(int start, int end) {
        this.starts.add(start);
        this.startToEndMap.put(start, end);
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
