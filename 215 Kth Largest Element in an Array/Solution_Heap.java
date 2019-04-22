class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>(k, (a, b) -> b - a);

        for(int n: nums) {
            maxHeap.offer(n);
        }

        int result = 0;
        for(int i = 0; i < k; i++) {
            result = maxHeap.poll();
        }
        return result;
    }
}