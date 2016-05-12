package org.tkzc.study.design.patterns.abstractt.factory;

import org.junit.Test;

public class AbstractFactoryTest {

	@Test
	public void testFactoryCreateMail() {
		Provider provider = new MailSenderFactory();
		Sender sneder = provider.produce();
		sneder.send();
	}
	
	@Test
	public void testFactoryCreateSms() {
		Provider provider = new SmsSenderFactory();
		Sender sneder = provider.produce();
		sneder.send();
	}
}
