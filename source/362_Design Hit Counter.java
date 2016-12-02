public class HitCounter {
    
    Deque<Integer> timeList;

    /** Initialize your data structure here. */
    public HitCounter() {
        timeList = new LinkedList<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        timeList.addLast(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int earliest = timestamp - 300 > 0 ? timestamp - 300 : 0;
        while(!timeList.isEmpty() && earliest >= timeList.peekFirst()) {
            timeList.removeFirst();
        }
        return timeList.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
 