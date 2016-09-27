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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> results = new ArrayList<>();
        if(intervals == null || intervals.isEmpty())    return results;
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval l1, Interval l2){

                // Since all start time (int) is positive number
                // Directly using x - y will not cause the overflow
                return l1.start - l2.start;
            }
        });
        int s = intervals.get(0).start;
        int e = intervals.get(0).end;
        for(int i = 0; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if(current.start <= e) {
                e = Math.max(e, current.end);
            } else {
                results.add(new Interval(s, e));
                s = current.start;
                e = current.end;
            }
        }

        // Add the last one
        results.add(new Interval(s, e));
        return results;
    }
}
