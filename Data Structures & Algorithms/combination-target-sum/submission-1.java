class Solution {
    List<List<Integer>> list = new ArrayList<>();
    int[] nums;
    int target;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        List<Integer> current = new ArrayList<>();
        backtrack(0, current, 0);
        return list;
    }

    private void backtrack(int index, List<Integer> current, int sum) {
        if (sum == target) {
            list.add(new ArrayList<>(current));
            return;
        }

        if (sum > target || index == nums.length) {
            return;
        }

        current.add(nums[index]);
        backtrack(index, current, sum + nums[index]);
        current.remove(current.size() - 1);
        backtrack(index + 1, current, sum);
    }
}
