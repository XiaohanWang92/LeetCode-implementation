public class Vector2D {

    LinkedList<Iterator> iterator2d;

    public Vector2D(List<List<Integer>> vec2d) {
        iterator2d = new LinkedList<Iterator>();
        for(List l : vec2d) {
            if(l.size() != 0) {
                iterator2d.add(l.iterator());
            }
        }
    }

    public int next() {
        Iterator iterator = iterator2d.remove();
        int result = (Integer)iterator.next();
        if(iterator.hasNext()) {
            iterator2d.addFirst(iterator);
        }
        return result;
    }

    public boolean hasNext() {
        return iterator2d.size() != 0;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
