class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int start, max;
        start = max = 0;

        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) start = Math.max(map.get(arr[i]) + 1, start);
            map.put(arr[i], i);

            max = Math.max(max, i - start + 1);
        }

        return max;
    }
}
