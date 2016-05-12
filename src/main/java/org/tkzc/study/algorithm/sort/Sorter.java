package org.tkzc.study.algorithm.sort;

import java.util.List;

public interface Sorter<T> {

	enum sort_algorithm {
		BUBBLE
	}
	
	void sort(List<T> coll);
	
	void swap(List<T> coll, int i, int j);
}
