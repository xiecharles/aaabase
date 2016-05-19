package org.tkzc.study.design.patterns.iterator;

public interface Iterator<E> {

	/**
	 * 前一个
	 * @return
	 */
	E previous();
	
	/**
	 * 下一个
	 * @return
	 */
	E next();
	
	/**
	 * 是否有下一个
	 * @return
	 */
	boolean hasNext();
	
	/**
	 * 第一个
	 * @return
	 */
	E first();
}
