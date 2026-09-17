class Solution {
    List<List<Integer>> list = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        List<Integer> current = new ArrayList<>();
        backtrack(current, new boolean[nums.length]);
        return list;
    }

    private void backtrack(List<Integer> current, boolean[] used) {
        if (current.size() == nums.length) {
            list.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            current.add(nums[i]);
            used[i] = true;
            backtrack(current, used);

            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
