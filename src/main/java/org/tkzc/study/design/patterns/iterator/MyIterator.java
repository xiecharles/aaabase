package org.tkzc.study.design.patterns.iterator;

import java.util.NoSuchElementException;

public class MyIterator<E> implements Iterator<E> {

	private Collection<E> collection;
	
	private int pos = -1;
	
	public MyIterator(Collection<E> collection) {
		super();
		this.collection = collection;
	}
	
	@Override
	public E previous() {
		if(pos <= 0) {
			throw new NoSuchElementException("current index on fisrt");
		}
		return collection.get(--pos);
	}

	@Override
	public E next() {
		if(pos >= collection.size()) {
			throw new NoSuchElementException("current index on last");
		}
		return collection.get(++pos);
	}

	@Override
	public boolean hasNext() {
		return pos < (collection.size() - 1);
	}

	@Override
	public E first() {
		if(collection == null) {
			throw new NullPointerException("collection is null");
		}
		if(collection.size() == 0) {
			throw new NoSuchElementException("collection is empty");
		}
		return collection.get(pos = 0);
	}
}
