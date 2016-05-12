package org.tkzc.study.design.patterns.abstractt.factory;

public class MailSenderFactory implements Provider {

	@Override
	public Sender produce() {
		return new MailSender();
	}

}
