package org.tkzc.study.design.patterns.mediator;

public abstract class User {

	private Mediator mediator;

	public User(Mediator mediator) {
		this.mediator = mediator;
	}

	public Mediator getMediator() {
		return mediator;
	}

	protected abstract void work();
}
