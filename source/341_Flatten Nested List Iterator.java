/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private LinkedList<Integer> flattenList;

    public NestedIterator(List<NestedInteger> nestedList) {
        flattenList = new LinkedList<Integer>();
        if(nestedList != null)
            flattenNestedList(nestedList, flattenList);
    }

    @Override
    public Integer next() {
        return flattenList.poll();
    }

    @Override
    public boolean hasNext() {
        return flattenList.isEmpty() ? false : true;
    }
    
    private void flattenNestedList(List<NestedInteger> nestedList, LinkedList<Integer> flattenList){
        for(NestedInteger element : nestedList) {
            if(element.isInteger()) {
                flattenList.offer(element.getInteger());
            } else {
                flattenNestedList(element.getList(), flattenList);
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
 