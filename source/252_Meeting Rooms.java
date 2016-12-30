/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null) return false;
        int len = intervals.length;
        if(len <= 1)  return true;
        Arrays.sort(intervals, new Comparator<Interval>() {

            @Override
            public int compare(Interval a, Interval b) {
                if(a.start == b.start)    return 0;
                return a.start > b.start ? 1 : -1;
            }
        });
        int end = intervals[0].end;
        for(int i = 1; i < len; i++) {
            if(end > intervals[i].start)  return false;
            end = intervals[i].end;
        }
        return true;
    }
}
