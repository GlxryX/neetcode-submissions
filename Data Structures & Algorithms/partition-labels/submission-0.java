class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();

        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        List<Integer> res = new ArrayList<>();
        int length = 0;
        int end = -1;

        for (int i = 0; i < arr.length; i++) {
            end = Math.max(end, map.get(arr[i]));
            ++length;
            if (i == end) {
                res.add(length);
                length = 0;
                end = -1;
            }
        }

        return res;
    }
}
