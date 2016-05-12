package org.tkzc.study.design.patterns.factory.method.single.method;

import org.tkzc.study.design.patterns.factory.method.MailSender;
import org.tkzc.study.design.patterns.factory.method.Sender;
import org.tkzc.study.design.patterns.factory.method.SmsSender;

public class SenderFactory {

	public Sender produce(String type) {
		if("mail".equals(type)) {
			return new MailSender();
		} else if("sms".equals(type)) {
			return new SmsSender();
		} else {
			System.out.println("请输入正确的类型");
			return null;
		}
	}
}
