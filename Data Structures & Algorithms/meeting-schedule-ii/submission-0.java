/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];

        for (int i = 0; i < intervals.size(); i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int res, count, s, e;
        res = count = s = e = 0;

        while (s < intervals.size()) {
            if (start[s] < end[e]) {
                s += 1;
                count += 1;
            } else {
                e += 1;
                count -= 1;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
