package org.tkzc.study.design.patterns.observer;

public class MySubject extends AbstractSubject {

	@Override
	public void operation() {
		System.out.println("self operate!");
		// 通知其他的观察者
		notifyObservers();
	}
}
