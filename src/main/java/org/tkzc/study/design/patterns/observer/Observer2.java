package org.tkzc.study.design.patterns.observer;

public class Observer2 implements Observer {

	@Override
	public void update() {
		System.out.println("observer2 has received!");
	}
}
