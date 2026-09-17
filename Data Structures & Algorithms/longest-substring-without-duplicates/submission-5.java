class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;

        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                if (map.get(arr[i]) >= start)
                    start = map.get(arr[i]) + 1;
            }
            max = Math.max(max, i - start + 1);
            map.put(arr[i], i);
        }

        return max;
    }
}
