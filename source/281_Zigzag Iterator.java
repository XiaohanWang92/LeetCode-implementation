public class ZigzagIterator {
    private LinkedList<Iterator> iter;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        iter = new LinkedList<Iterator>();
        if(!v1.isEmpty()) iter.add(v1.iterator());
        if(!v2.isEmpty()) iter.add(v2.iterator());
    }

    public int next() {
        Iterator itr = iter.remove();
        int result = (Integer)itr.next();//what happen if not cast?
	//Line 12: error: incompatible types: Object cannot be converted to int
        if(itr.hasNext()) {
            iter.add(itr);
        }
        return result;
    }

    public boolean hasNext() {
        return !iter.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */

// no iterator!
public class ZigzagIterator {
    
    private Deque<List<Integer>> zigzagQueue;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        zigzagQueue = new LinkedList<List<Integer>>();
        if(v1 != null && v1.size() != 0)
            zigzagQueue.offer(v1);
        if(v2 != null && v2.size() != 0)
            zigzagQueue.offer(v2);
    }

    public int next() {
        List<Integer> l = zigzagQueue.poll();
        int result = l.remove(0);
        if(l.size() != 0)
            zigzagQueue.offer(l);
        return result;
    }

    public boolean hasNext() {
        return zigzagQueue.size() > 0;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
