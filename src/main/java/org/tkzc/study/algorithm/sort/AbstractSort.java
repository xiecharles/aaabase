package org.tkzc.study.algorithm.sort;

import java.util.List;

public abstract class AbstractSort<T> implements Sorter<T> {

	public void swap(List<T> coll, int i, int j) {
		T temp = coll.get(i);
		coll.set(i, coll.get(j));
		coll.set(j, temp);
	}
}
