
package org.tkzc.study.design.patterns.mediator;

public class User2 extends User {

	public User2(Mediator mediator) {
		super(mediator);
	}

	@Override
	protected void work() {
		System.out.println("user2 exe!");
	}
}
