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
        List<Interval> res = new ArrayList<>();
        if(intervals == null || intervals.isEmpty())    return res;
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval l1, Interval l2){
                //since all start time (int) is positive number
                //using directly x - y will not cause the overflow
                return l1.start - l2.start;
            }
        });
        int s = intervals.get(0).start;
        int e = intervals.get(0).end;
        for(int i = 0; i < intervals.size(); i++){
            Interval curr = intervals.get(i);
            if(curr.start <= e){
                e = Math.max(e, curr.end);
            }else{
                res.add(new Interval(s, e));
                s = curr.start;
                e = curr.end;
            }
        }
        //add the last one
        res.add(new Interval(s, e));
        return res;
    }
}
