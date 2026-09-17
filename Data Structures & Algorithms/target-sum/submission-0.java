class Solution {
    int[] nums;
    int target;
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        return backtrack(0, 0);
    }

    private int backtrack(int index, int total) {
        if (index == nums.length) {
            return total == target ? 1 : 0;
        }

        return backtrack(index + 1, total + nums[index]) + backtrack(index + 1, total - nums[index]);
    }
}
