package org.tkzc.study.design.patterns.factory.method.multi.method;

import org.tkzc.study.design.patterns.factory.method.MailSender;
import org.tkzc.study.design.patterns.factory.method.Sender;
import org.tkzc.study.design.patterns.factory.method.SmsSender;

public class SenderFactory {

	public Sender produceMail() {
		return new MailSender();
	}
	
	public Sender produceSms() {
		return new SmsSender();
	}
}
