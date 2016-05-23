package org.tkzc.study.design.patterns.mediator;

import org.junit.Test;

public class MediatorTest {

	@Test
	public void testMediator() {
		Mediator mediator = new MyMediator();
		mediator.createMediator();
		mediator.workAll();
	}
}
