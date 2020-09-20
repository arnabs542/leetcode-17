class Solution {
    // this is referred from: https://leetcode.com/problems/minimum-height-trees/discuss/76055/Share-some-thoughts
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        // construct graph
        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // construct 1st iteration of leaves
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            if (adj.get(i).size() == 1) leaves.add(i);

        // remove leaves by iteration until less than 2 nodes are left
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if (adj.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }

        return leaves;
    }

    // Note: this Solution will timeout on big input data
    public List<Integer> findMinHeightTrees_BFS(int n, int[][] edges) {
        // Brute Force, try each possible case that each vertex can be the root node
        List<Integer> minHeightTrees = new ArrayList<>();

        // special case handling
        if (n == 0) return minHeightTrees;
        if (n == 1) {
            minHeightTrees.add(0);
            return minHeightTrees;
        }

        // construct the graph
        int[][] graph = new int[n][n];
        for (int i = 0; i < edges.length; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            graph[node1][node2] = 1;
            graph[node2][node1] = 1;
        }

        // calculate height for each case
        int minHeight = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int currentHeight = getHeight(graph, i);
            if (currentHeight < minHeight) {
                minHeightTrees.clear();
                minHeightTrees.add(i);
                minHeight = currentHeight;
            } else if (currentHeight == minHeight) {
                minHeightTrees.add(i);
            }
        }

        return minHeightTrees;
    }

    private int getHeight(int[][] graph, int root) {
        // use BFS to calculate height of the tree
        int nodes = graph.length;
        int[] visited = new int[nodes];
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> heightQueue = new LinkedList<>();
        int height = 0;

        queue.add(root);
        heightQueue.add(0);
        visited[root] = 1;
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            int currentHeight = heightQueue.poll();
            if (currentHeight > height) height = currentHeight;
            List<Integer> children = getConnectedNodes(graph, currentNode);
            for (int child: children) {
                if (visited[child] != 1) {
                    queue.add(child);
                    heightQueue.add(currentHeight + 1);
                    visited[child] = 1;
                }
            }
        }

        return height;
    }

    private List<Integer> getConnectedNodes(int[][] graph, int node) {
        List<Integer> connectedNodes = new ArrayList<>();
        int nodes = graph.length;
        for (int i = 0; i < nodes; i++) {
            if (graph[node][i] == 1) {
                connectedNodes.add(i);
            }
        }
        return connectedNodes;
    }
}