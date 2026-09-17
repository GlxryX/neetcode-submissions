class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> list = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] <= end) {
                end = Math.max(end, interval[1]);
            } else {
                list.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }

        list.add(new int[]{start, end});

        return list.toArray(new int[list.size()][]);
    }
}
