package org.tkzc.study.design.patterns.abstractt.factory;

public class SmsSenderFactory implements Provider {

	@Override
	public Sender produce() {
		return new SmsSender();
	}

}
