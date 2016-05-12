package org.tkzc.study.design.patterns.factory.method.multi.method;

import org.junit.Test;
import org.tkzc.study.design.patterns.factory.method.Sender;

public class FactoryMethodTest {

	@Test
	public void testFactoryCreateMai() {
		SenderFactory factory = new SenderFactory();
		Sender sender = factory.produceMail();
		sender.send();
	}
	
	@Test
	public void testFactoryCreateSms() {
		SenderFactory factory = new SenderFactory();
		Sender sender = factory.produceSms();
		sender.send();
	}
}
