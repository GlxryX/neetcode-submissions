class Solution {
    public int[] productExceptSelf(int[] nums) {
        boolean hasZero = false;
        boolean allZero = false;
        int product = 1;

        for (int num : nums) {
            if (num == 0) {
                if (hasZero) allZero = true;
                else hasZero = true;
            }
            else product *= num;
        }

        if (allZero) product = 0;

        for (int i = 0; i < nums.length; i++) {
            if (hasZero) {
                if (nums[i] == 0) nums[i] = product;
                else nums[i] = 0;
            } else {
                nums[i] = product / nums[i];
            }
        }

        return nums;
    }
}  
