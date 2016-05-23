package org.tkzc.study.design.patterns.state;

public class Context {

	private State state;

	public Context(State state) {
		super();
		this.state = state;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public void method() {
		if(state.getValue().equals("state1")) {
			state.method1();
		} else if(state.getValue().equals("state2")) {
			state.method2();
		}
	}
}
