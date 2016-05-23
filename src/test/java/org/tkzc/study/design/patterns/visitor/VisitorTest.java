package org.tkzc.study.design.patterns.visitor;

import org.junit.Test;

public class VisitorTest {

	@Test
	public void testVisitor() {
		Visitor visitor = new MyVisitor();
		Subject subject = new MySubject();
		subject.accept(visitor);
	}
}
