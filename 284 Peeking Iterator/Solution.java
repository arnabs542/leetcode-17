// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Integer next = null;
    private Iterator<Integer> iterator = null;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        this.iterator = iterator;
        if (iterator.hasNext()) {
            this.next = iterator.next();
        } else {
            this.next = null;
        }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return this.next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        Integer currentNext = this.next;
        if (this.iterator.hasNext()) {
            this.next = this.iterator.next();
        } else {
            this.next = null;
        }
        return currentNext;
	}

	@Override
	public boolean hasNext() {
        return (this.next != null);
	}
}

// another approach: https://github.com/google/guava/blob/703ef758b8621cfbab16814f01ddcc5324bdea33/guava-gwt/src-super/com/google/common/collect/super/com/google/common/collect/Iterators.java#L1125