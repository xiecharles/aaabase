package org.tkzc.study.design.patterns.bridge;

public class SourceSub1 implements Sourceable {

	@Override
	public void method() {
		System.out.println("this is the sub1 method!");
	}
}
