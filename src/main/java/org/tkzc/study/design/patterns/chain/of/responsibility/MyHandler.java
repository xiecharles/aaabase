package org.tkzc.study.design.patterns.chain.of.responsibility;

public class MyHandler extends AbstractHandler implements Handler {

	String name;
	
	public MyHandler(String name) {
		super();
		this.name = name;
	}

	@Override
	public void operation() {
		System.out.println(name + " deal!");
		if(getHandler() != null) {
			getHandler().operation();
		}
	}
}
