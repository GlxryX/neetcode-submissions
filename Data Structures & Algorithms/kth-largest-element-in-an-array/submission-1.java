class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            heap.add(num);
        }

        int res = 0;
        for (int i = 0; i < k; i++) {
            res = heap.poll();
        }

        return res;
    }
}
