// please find the reference here: https://leetcode.com/problems/beautiful-arrangement/description/
class Solution {
    private int arrangementCount;

    public int countArrangement(int N) {
        this.arrangementCount = 0;
        int[] visited = new int[N + 1];
        for (int i = 0; i <= N; i++) visited[i] = 0;
        this.findNumber(N, 1, visited);
        return this.arrangementCount;
    }

    private void findNumber(int N, int pos, int[] visited) {
        if (pos > N) {
            arrangementCount++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(visited[i] == 0 && (pos % i == 0 || i % pos == 0)) {
                visited[i] = 1;
                findNumber(N, pos + 1, visited);
                visited[i] = 0;
            }
        }
    }
}
