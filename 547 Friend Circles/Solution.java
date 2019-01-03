class Solution {
    // use Union-Find data structure (Disjoint Set)
    class DisjointSet {
        private int[] parent;

        public DisjointSet(int n) {
            parent = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int n) {
            if(parent[n] == n) return n;
            return find(parent[n]);
        }

        public void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);

            if(parentX == parentY) return;
            if(parentX < parentY) {
                parent[parentY] = parentX;
            } else {
                parent[parentX] = parentY;
            }
        }
    }

    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0 || M.length != M[0].length) return 0;

        int n = M.length;

        DisjointSet groups = new DisjointSet(n);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(M[i][j] == 1) groups.union(i, j);
            }
        }

        Set<Integer> groupSet = new HashSet<>();
        for(int i = 0; i < n; i++) {
            groupSet.add(groups.find(i));
        }

        return groupSet.size();
    }
}