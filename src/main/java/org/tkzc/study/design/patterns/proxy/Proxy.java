package org.tkzc.study.design.patterns.proxy;

public class Proxy implements Sourceable {

	private Source source;
	
	public Proxy() {
		super();
		this.source = new Source();
	}

	@Override
	public void methid() {
		before();
		source.methid();
		after();
	}

	private void after() {
		System.out.println("after proxy!");
	}

	private void before() {
		System.out.println("before proxy!");
	}
}
