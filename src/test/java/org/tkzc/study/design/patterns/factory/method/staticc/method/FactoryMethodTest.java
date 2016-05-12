package org.tkzc.study.design.patterns.factory.method.staticc.method;

import org.junit.Test;
import org.tkzc.study.design.patterns.factory.method.Sender;

public class FactoryMethodTest {

	@Test
	public void testFactoryCreateMai() {
		Sender sender = SenderFactory.produceMail();
		sender.send();
	}
	
	@Test
	public void testFactoryCreateSms() {
		Sender sender = SenderFactory.producesSms();
		sender.send();
	}
}
