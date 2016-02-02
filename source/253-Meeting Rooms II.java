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
    class myCom implements Comparator<Interval>{
        public int compare(Interval i1, Interval i2){
            return i1.end - i2.end;
        }
    }
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals==null || intervals.length==0)
            return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        
        PriorityQueue<Interval> rooms = new PriorityQueue<>(intervals.length, new myCom());
        
        rooms.add(intervals[0]);
        
        for(int i=1; i<intervals.length; i++){
            Interval fitRoom = rooms.poll();
            if(intervals[i].start >= fitRoom.end){
                fitRoom.end = intervals[i].end;
                rooms.offer(fitRoom);
            }else{
                rooms.offer(intervals[i]);
                rooms.offer(fitRoom);
            }
        }
        return rooms.size();
    }
}
