// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> myIter;
    private Integer nextInt = null;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    myIter = iterator;
	    if(myIter.hasNext())
	        nextInt = myIter.next();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return nextInt;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer res = nextInt;
	    if(myIter.hasNext())
	        nextInt = myIter.next();
	    else
	        nextInt = null;
	    return res;
	}

	@Override
	public boolean hasNext() {
	    return nextInt!=null;
	}
}
