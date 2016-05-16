package org.tkzc.study.design.patterns.builder;

import org.junit.Test;

public class BuilderTest {

	@Test
	public void testBuilder() {
		Builder builder = new Builder();
		builder.produceMailSender(5);
		builder.produceSmsSender(3);
		for (Sender sender : builder.getList()) {
			sender.send();
		}
	}
}
