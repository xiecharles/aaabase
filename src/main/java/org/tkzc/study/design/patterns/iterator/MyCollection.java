package org.tkzc.study.design.patterns.iterator;

public class MyCollection<E> implements Collection<E> {

	/**
	 * 初始化集合大小
	 */
	private static final int initSize = 10;
	
	/**
	 * 实际装载数据的数组
	 */
	private E[] data;
	
	/**
	 * 当前指向最后一个元素的索引
	 */
	private int pos = -1;
	
	/**
	 * 当前集合最大容量
	 */
	private int maxSpace = 0;
	
	/**
	 * 集合自动扩容的大小
	 */
	private int incStep = 5;
	
	public MyCollection() {
		this(initSize);
	}
	
	@SuppressWarnings("unchecked")
	public MyCollection(int initialize) {
		super();
		data = (E[]) new Object[initialize];
		maxSpace += initialize;
	}

	@Override
	public Iterator<E> iterator() {
		return new MyIterator<E>(this);
	}

	@Override
	public void add(E ele) {
		if((pos + 1) == maxSpace) {
			dataInc();
		}
		data[++pos] = ele;
	}

	@Override
	public E get(int index) {
		if(index > pos || index < 0) {
			throw new IndexOutOfBoundsException("max index: " + pos + " but given index: " + index);
		}
		return data[index];
	}

	@Override
	public int size() {
		return pos + 1;
	}

	@SuppressWarnings("unchecked")
	private synchronized void dataInc() {
		E[] old = data;
		E[] inc = (E[]) new Object[incStep];
		data = (E[]) new Object[old.length + incStep];
		System.arraycopy(old, 0, data, 0, old.length);
		System.arraycopy(inc, 0, data, old.length, inc.length);
		maxSpace += incStep;
	}
}
