class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len < 2) return len;
        int longest = 1;
        int start = 0;
        int end = 1;

        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);

        while (end < len) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(start, map.get(s.charAt(end)) + 1);
            }
            
            longest = Math.max(longest, end - start + 1);
            map.put(s.charAt(end), end);
            end++;
        }

        return longest;
    }
}
