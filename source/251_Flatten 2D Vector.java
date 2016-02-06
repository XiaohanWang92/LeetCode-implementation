public class Vector2D {
    LinkedList<Iterator> iter2d;
    public Vector2D(List<List<Integer>> vec2d) {
        iter2d = new LinkedList<Iterator>();
        for(List l : vec2d){
            if(l.size()!=0){
                iter2d.add(l.iterator());
            }
        }
    }

    public int next() {
        Iterator iter = iter2d.remove();
        int res = (Integer)iter.next();
        if(iter.hasNext()){
            iter2d.addFirst(iter);
        }
        return res;
    }

    public boolean hasNext() {
        return iter2d.size()!=0;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
