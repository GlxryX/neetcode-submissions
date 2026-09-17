class Solution {
    public int longestOnes(int[] nums, int k) {
        int l, len;
        l = len = 0;
        for (int r = 0; r < nums.length; r++) {
            k -= nums[r] == 0 ? 1 : 0;
            while (k < 0) {
                k += nums[l] == 0 ? 1 : 0;
                l++;
            }
            len = Math.max(len, r - l + 1);
        }

        return len;
    }
}