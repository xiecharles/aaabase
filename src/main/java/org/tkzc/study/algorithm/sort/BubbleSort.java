package org.tkzc.study.algorithm.sort;

import java.util.List;

public class BubbleSort<T extends Comparable<T>> extends AbstractSort<T> implements Sorter<T> {

	public void sort(List<T> coll) {
		if(coll == null) {
			return ;
		}
		
		int len = coll.size();
		for(int i=0; i<len-1; i++) {
			for(int j=i+1; j<len; j++) {
				if(coll.get(i).compareTo(coll.get(j)) > 0) {
					super.swap(coll, i, j);
				}
			}
		}
	}
}
