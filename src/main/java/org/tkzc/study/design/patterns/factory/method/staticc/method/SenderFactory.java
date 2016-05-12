package org.tkzc.study.design.patterns.factory.method.staticc.method;

import org.tkzc.study.design.patterns.factory.method.MailSender;
import org.tkzc.study.design.patterns.factory.method.Sender;
import org.tkzc.study.design.patterns.factory.method.SmsSender;

public class SenderFactory {

	public static Sender produceMail() {
		return new MailSender();
	}
	
	public static Sender producesSms() {
		return new SmsSender();
	}
}
