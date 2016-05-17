package org.tkzc.study.design.patterns.adapter.interfacee;

import org.junit.Test;

public class WrapperTest {

	@Test
	public void testWrapper() {
		Sourceable sub1 = new SourceSub1();
		Sourceable sub2 = new SourceSub2();
		
		sub1.method1();
		sub1.method2();
		sub2.method1();
		sub2.method2();
	}
}
