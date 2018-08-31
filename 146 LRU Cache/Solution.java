class LRUCache {
    int capacity;
    private Map<Integer, Integer> cacheMap;
    Queue<Integer> cacheQueue;
    private Map<Integer, Integer> keyOccurMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.keyOccurMap = new HashMap<>();
        this.cacheQueue = new LinkedList<>();
    }

    public int get(int key) {
        if (this.cacheMap.get(key) != null) {
        	recordUsage(key);
            return this.cacheMap.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        // new value
        if (this.cacheMap.get(key) == null &&
            this.cacheMap.size() >= this.capacity) {
            // delete the oldest value in the queue
            int pullOutKey = this.cacheQueue.poll();
            int keyOccur = this.keyOccurMap.get(pullOutKey) - 1;
            this.keyOccurMap.put(pullOutKey, keyOccur);
            while (keyOccur != 0) {
                pullOutKey = this.cacheQueue.poll();
                keyOccur = this.keyOccurMap.get(pullOutKey) - 1;
                this.keyOccurMap.put(pullOutKey, keyOccur);
            }
            this.cacheMap.remove(pullOutKey);
        }

        // add new value
        recordUsage(key);
        this.cacheMap.put(key, value);
    }

    private void recordUsage(int key) {
        this.cacheQueue.add(key);
        if (this.keyOccurMap.get(key) != null &&
            this.keyOccurMap.get(key) > 0) {
            this.keyOccurMap.put(key, this.keyOccurMap.get(key) + 1);
        } else {
            this.keyOccurMap.put(key, 1);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */