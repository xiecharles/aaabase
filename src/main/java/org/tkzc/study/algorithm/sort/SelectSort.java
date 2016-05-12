package org.tkzc.study.algorithm.sort;

import java.util.List;

public class SelectSort<T extends Comparable<T>> extends AbstractSort<T> implements Sorter<T> {

	public void sort(List<T> coll) {
		if(coll == null) {
			return ;
		}
		
		int len = coll.size();
		int minIndex = 0;
		for(int i=0; i<len-1; i++) {
			minIndex = i;
			for(int j=i+1; j<len; j++) {
				if(coll.get(minIndex).compareTo(coll.get(j)) > 0) {
					minIndex = j;
				}
			}
			if(i != minIndex) {
				super.swap(coll, i, minIndex);
			}
		}
	}
}
