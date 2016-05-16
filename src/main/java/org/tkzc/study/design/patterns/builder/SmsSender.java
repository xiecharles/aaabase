package org.tkzc.study.design.patterns.builder;

public class SmsSender implements Sender {

	@Override
	public void send() {
		System.out.println("send a sms");
	}

}
