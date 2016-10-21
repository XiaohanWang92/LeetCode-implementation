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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }
        int index = 0;
        while(index < intervals.size() && intervals.get(index).end < newInterval.start) {
            result.add(intervals.get(index));
            index++;
        }
        int mergeStart = newInterval.start;
        int mergeEnd = newInterval.end;
        while(index < intervals.size()) {
            if(intervals.get(index).start > newInterval.end)    break;
            mergeStart = Math.min(mergeStart, intervals.get(index).start);
            mergeEnd = Math.max(mergeEnd, intervals.get(index).end);
            index++;
        }
        Interval merge = new Interval(mergeStart, mergeEnd);
        result.add(merge);
        while(index < intervals.size()) {
            result.add(intervals.get(index));
            index++;
        }
        return result;
    }
}
