package org.tkzc.study.design.patterns.factory.method;

public class SmsSender implements Sender {

	@Override
	public void send() {
		System.out.println("send a sms");
	}

}
