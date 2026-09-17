class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) return new int[]{++left, ++right};
            if (sum > target) --right;
            else ++left; // sum < target
        }

        return new int[0];
    }
}
