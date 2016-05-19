package org.tkzc.study.design.patterns.iterator;

public interface Collection<E> {

	Iterator<E> iterator();
	
	void add(E ele);
	
	E get(int index);
	
	int size();
}
