class Solution {
    public int scoreOfString(String s) {
        int sum = 0;
        char[] arr = s.toCharArray();

        for (int i = 1; i < s.length(); i++) {
            sum += Math.abs(arr[i] - arr[i - 1]);
        }

        return sum;
    }
}