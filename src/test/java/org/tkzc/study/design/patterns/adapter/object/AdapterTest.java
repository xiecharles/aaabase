package org.tkzc.study.design.patterns.adapter.object;

import org.junit.Test;

public class AdapterTest {

	@Test
	public void testAdapter() {
		Source source = new Source();
		Targetable target = new Wrapper(source);
		target.method1();
		target.method2();
	}
}
