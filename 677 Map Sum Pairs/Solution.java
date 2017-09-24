class MapSum {
    private Map<String, Integer> mapSum;

    /** Initialize your data structure here. */
    public MapSum() {
        mapSum = new HashMap<String, Integer>();
    }

    public void insert(String key, int val) {
        mapSum.put(key, val);
    }

    public int sum(String prefix) {
        int sumMap = 0;
        for (String s: mapSum.keySet()) {
            if (s.startsWith(prefix)) {
                sumMap += mapSum.get(s);
            }
        }
        return sumMap;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
