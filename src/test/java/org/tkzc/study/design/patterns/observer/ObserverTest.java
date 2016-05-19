package org.tkzc.study.design.patterns.observer;

import org.junit.Test;

public class ObserverTest {

	@Test
	public void testObserver() {
		Subject sub = new MySubject();
		sub.add(new Observer1());
		sub.add(new Observer2());
		sub.operation();
	}
}
