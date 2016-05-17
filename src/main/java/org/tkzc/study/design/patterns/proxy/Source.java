package org.tkzc.study.design.patterns.proxy;

public class Source implements Sourceable {

	@Override
	public void methid() {
		System.out.println("the original method!");
	}
}
