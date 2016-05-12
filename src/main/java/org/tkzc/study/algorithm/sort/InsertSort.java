package org.tkzc.study.algorithm.sort;

import java.util.List;

public class InsertSort<T extends Comparable<T>> extends AbstractSort<T> implements Sorter<T> {

	public void sort(List<T> coll) {
		if(coll == null) {
			return ;
		}
		
		int len = coll.size();
		int insertIndex = 0;
		for(int i=1; i<len; i++) {
			T temp = (T) coll.get(i);
			insertIndex = i;
			while((insertIndex > 0) && (temp.compareTo(coll.get(insertIndex - 1)) < 0)) {
				coll.set(insertIndex, coll.get(insertIndex - 1));
				insertIndex--;
			}
			coll.set(insertIndex, temp);
		}
	}
}
