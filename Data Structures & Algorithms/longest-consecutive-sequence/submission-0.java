class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> store = new HashSet<>();
        for (int num : nums) {
            store.add(num);
        }

        for (int num : nums) {
            int streak = 0, curr = num;
            while (store.contains(curr)) {
                streak++;
                curr++;
            }
            max = Math.max(max, streak);
        }
        return max;
    }
}
