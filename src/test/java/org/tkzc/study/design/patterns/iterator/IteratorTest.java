package org.tkzc.study.design.patterns.iterator;

import org.junit.Test;

public class IteratorTest {

	@Test
	public void testIterator() {
		Collection<String> coll = new MyCollection<String>();
		coll.add("1");
		coll.add("2");
		coll.add("3");
		coll.add("4");
		coll.add("5");
		coll.add("6");
		coll.add("7");
		coll.add("8");
		coll.add("9");
		coll.add("10");
		coll.add("11");
		coll.add("12");
		coll.add("13");
		coll.add("14");
		coll.add("15");
		coll.add("16");
		Iterator<String> it = coll.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
