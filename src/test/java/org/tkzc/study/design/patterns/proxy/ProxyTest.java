package org.tkzc.study.design.patterns.proxy;

import org.junit.Test;

public class ProxyTest {

	@Test
	public void testProxy() {
		Sourceable source = new Proxy();
		source.methid();
	}
}
