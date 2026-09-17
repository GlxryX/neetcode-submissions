class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);
            if (map.containsKey(sorted)) {
                map.get(sorted).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(sorted, list);
            }
        }
        
        return new ArrayList<>(map.values());
    }
}
