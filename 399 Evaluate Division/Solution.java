// reference: http://www.jianshu.com/p/197b14c564bc

// some thoughts: we can build a directed weighted graph, and search the possible path to calculate the result
// the implemenetation of the blog is to build a map of directed weighted gragh and use DFS to search the possible path to get the result
// Please note that the following code is directly copied from the blog!

public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

        // use map to build a direct weighted graph
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            insert(equations[i][0], equations[i][1], values[i], map);
            insert(equations[i][1], equations[i][0], 1.0 / values[i], map);
        }

        double[] arr = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            // use DFS to search the connected path to get the result
            Double ret = query(queries[i][0], queries[i][1], map, new HashSet<String>());
            if (ret == null) {
                arr[i] = -1.0;
            }
            else {
                arr[i] = ret;
            }
        }

        return arr;
    }

    private void insert(String num, String denum, double result, Map<String, Map<String, Double>> map) {
        if (!map.containsKey(num)) {
            map.put(num, new HashMap<String, Double>());
        }
        map.get(num).put(denum, result);
    }

    private Double query(String num, String denum, Map<String, Map<String, Double>> map, Set<String> set) {
        String key = num + "/" + denum;
        if (set.contains(key)) {
            return null;
        } else if (!map.containsKey(num) || !map.containsKey(denum)) {
            return null;
        }

        Map<String, Double> sub = map.get(num);
        if (sub.containsKey(denum)) {
            return sub.get(denum);
        }

        set.add(key);
        for (String curr : sub.keySet()) {
            Double ret = query(curr, denum, map, set);
            if (ret != null) {
                return sub.get(curr) * ret;
            }
        }
        set.remove(key);
        return null;
    }
}
