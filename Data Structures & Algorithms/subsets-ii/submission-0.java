class Solution {
    List<List<Integer>> list = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        List<Integer> current = new ArrayList<>();
        backtrack(0, current);
        return list;
    }

    private void backtrack(int index, List<Integer> current) {
        list.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            current.add(nums[i]);
            backtrack(i + 1, current);
            current.remove(current.size() - 1);
            // backtrack(i, current);
        }
    }
}
