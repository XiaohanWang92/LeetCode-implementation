public class ZigzagIterator {
    private LinkedList<Iterator> iter;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        iter = new LinkedList<Iterator>();
        if(!v1.isEmpty()) iter.add(v1.iterator());
        if(!v2.isEmpty()) iter.add(v2.iterator());
    }

    public int next() {
        Iterator itr = iter.remove();
        int res = (Integer)itr.next();//what happen if not cast?
	//Line 12: error: incompatible types: Object cannot be converted to int
        if(itr.hasNext()){
            iter.add(itr);
        }
        return res;
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
