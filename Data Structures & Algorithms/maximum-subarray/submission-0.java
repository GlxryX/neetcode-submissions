class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int max = nums[0];
        int currSum = 0;

        for (int num : nums) {
            if (currSum < 0) currSum = 0;
            currSum += num;
            max = Math.max(max, currSum);
        }

        return max;
    }
}
