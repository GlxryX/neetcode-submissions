class Solution {
    List<List<Integer>> list = new ArrayList<>();
    int[] nums;
    int target;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.nums = candidates;
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

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
        
            current.add(nums[i]);
            backtrack(i + 1, current, sum + nums[i]);
            current.remove(current.size() - 1);
        }
    }
}
