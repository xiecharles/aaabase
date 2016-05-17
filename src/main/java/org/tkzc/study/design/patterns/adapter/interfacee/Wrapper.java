package org.tkzc.study.design.patterns.adapter.interfacee;

public abstract class Wrapper implements Sourceable {

	@Override
	public void method1() {
		System.out.println("method1 default!");
	}

	@Override
	public void method2() {
		System.out.println("method2 default!");
	}

}
