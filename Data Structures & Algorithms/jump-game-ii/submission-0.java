class Solution {
    public int jump(int[] nums) {
        int res, l, r;
        res = l = r = 0;

        while (r < nums.length - 1) {
            int furthest = 0;
            for (int i = l; i <= r; i++) {
                furthest = Math.max(furthest, nums[i] + i);
            }

            l = r + 1;
            r = furthest;
            res++;
        }

        return res;
    }
}
