package org.tkzc.study.design.patterns.decorator;

import org.junit.Test;

public class DecoratorTest {

	@Test
	public void testDecorator() {
		Sourceable source = new Source();
		Sourceable obj = new Decorator(source);
		obj.method();
	}
}
